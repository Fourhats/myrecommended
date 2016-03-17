package com.myrecommended.services.users.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

import org.apache.commons.lang.RandomStringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.business.emails.EmailManager;
import com.myrecommended.business.users.UserGenerator;
import com.myrecommended.business.users.UserSearcher;
import com.myrecommended.business.users.UserUpdater;
import com.myrecommended.constants.TempFolders;
import com.myrecommended.daos.UserDAO;
import com.myrecommended.models.User;
import com.myrecommended.services.users.UserService;
import com.myrecommended.services.users.dtos.AskNewPasswordRequestDTO;
import com.myrecommended.services.users.dtos.ChangePasswordRequestDTO;
import com.myrecommended.services.users.dtos.CurrentUserDTO;
import com.myrecommended.services.users.dtos.LoggedUserDTO;
import com.myrecommended.services.users.dtos.SendContactRequestDTO;
import com.myrecommended.services.users.dtos.UpdateUserRequestDTO;
import com.myrecommended.services.users.dtos.UserRequestDTO;
import com.myrecommended.services.utils.FileHelper;
import com.myrecommended.services.utils.MapperUtil;

public class UserServiceImpl implements UserService {

	@Autowired
	private Mapper mapper;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserGenerator userGenerator;
	
	@Autowired
	private UserSearcher userSearcher;
	
	@Autowired
	private UserUpdater userUpdater;
	
	@Autowired
	private EmailManager emailManager;
	
	@Value("#{configProps}")
	private Properties properties;
	
	public LoggedUserDTO getFbLoggedUserByEmail(String email) throws MyRecommendedBusinessException {
		User user = this.userSearcher.getFbLoggedUserByEmail(email);
		return MapperUtil.map(mapper, user, LoggedUserDTO.class);
	}

	public LoggedUserDTO addUser(UserRequestDTO userDto) throws MyRecommendedBusinessException {
		User user = this.userGenerator.generate(userDto);
		return MapperUtil.map(mapper, user, LoggedUserDTO.class);
	}
	
	public LoggedUserDTO addUser(com.restfb.types.User fbUser) throws MyRecommendedBusinessException {
		User user = this.userGenerator.generate(fbUser);
		return MapperUtil.map(mapper, user, LoggedUserDTO.class);
	}

	public boolean existUserWithEmail(String email) {
		return this.userSearcher.existUserWithEmail(email);
	}

	public void updateUser(UpdateUserRequestDTO userDto) throws FileNotFoundException, IOException, Exception {
		this.userUpdater.update(userDto);
		
		String tempPath = properties.getProperty("folder.temp");
		String avatarPath = properties.getProperty("folder.avatar");
		FileHelper.generateImagesWithDifferentSizes(userDto.getAvatarName(), tempPath, TempFolders.AVATAR_FOLDER.getValue(), avatarPath);
	}

	public CurrentUserDTO getUser(long userId) {
		User user = this.userSearcher.getUser(userId);
		return MapperUtil.map(mapper, user, CurrentUserDTO.class);
	}

	public void changePassword(ChangePasswordRequestDTO changePasswordDto) throws MyRecommendedBusinessException {
		this.userUpdater.changePassword(changePasswordDto);
	}

	public String getUserAvatar(long userId) {
		return this.getUser(userId).getAvatarName();
	}
	
	public void askForNewPassword(AskNewPasswordRequestDTO askNewPasswordDTO) throws MyRecommendedBusinessException, AuthenticationFailedException, MessagingException {
		String newPassword = RandomStringUtils.randomAlphanumeric(8);
		
		//TODO: MOVE TO VALIDATOR
		User user = this.userSearcher.getUser(askNewPasswordDTO.getEmail());
		if(user == null) {
			return;
		} else if (user.getSignInProvider() != null) {
			return;
		}
		
		ChangePasswordRequestDTO changePasswordDto = new ChangePasswordRequestDTO();
		changePasswordDto.setNewPassword(newPassword);
		changePasswordDto.setOldPassword(user.getPassword());
		changePasswordDto.setUserId(user.getId());
		
		this.userUpdater.changePassword(changePasswordDto);
	}

	//@Override
	public void sendContact(SendContactRequestDTO sendContactDto) {
		this.emailManager.SendContact(sendContactDto);
	}
}