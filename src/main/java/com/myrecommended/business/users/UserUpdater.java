package com.myrecommended.business.users;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.daos.UserDAO;
import com.myrecommended.models.User;
import com.myrecommended.services.users.dtos.ChangePasswordRequestDTO;
import com.myrecommended.services.users.dtos.UpdateUserRequestDTO;

@Component
public class UserUpdater {

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private UserFactory userFactory;
	
	@Autowired
	private UserDAO userDao;
	
	public void update(UpdateUserRequestDTO userDto) throws MyRecommendedBusinessException {
		this.userValidator.validateIfCanBeUpdated(userDto);
		User user = this.userDao.getById(userDto.getId());
		user.setAvatarName(userDto.getAvatarName());
		user.setName(userDto.getName());
		user.setSurname(userDto.getSurname());
		user.setUpdateDate(new Date());
		
		this.userDao.add(user);
	}

	public void changePassword(ChangePasswordRequestDTO changePasswordDto) throws MyRecommendedBusinessException {
		this.userValidator.validateIfCanChangePassword(changePasswordDto);
		User user = this.userDao.getById(changePasswordDto.getUserId());
		user.setPassword(changePasswordDto.getNewPassword());
		
		this.userDao.add(user);
	}
}