package com.myrecommended.services.users.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.business.users.UserGenerator;
import com.myrecommended.business.users.UserSearcher;
import com.myrecommended.business.users.UserUpdater;
import com.myrecommended.daos.UserDAO;
import com.myrecommended.models.User;
import com.myrecommended.services.users.UserService;
import com.myrecommended.services.users.dtos.ChangePasswordRequestDTO;
import com.myrecommended.services.users.dtos.LoggedUserDTO;
import com.myrecommended.services.users.dtos.UpdateUserRequestDTO;
import com.myrecommended.services.users.dtos.UserDTO;
import com.myrecommended.services.users.dtos.UserRequestDTO;
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

	public void updateUser(UpdateUserRequestDTO userDto) throws MyRecommendedBusinessException {
		this.userUpdater.update(userDto);
	}

	public UserDTO getUser(long userId) {
		User user = this.userSearcher.getUser(userId);
		return MapperUtil.map(mapper, user, UserDTO.class);
	}

	public void changePassword(ChangePasswordRequestDTO changePasswordDto) throws MyRecommendedBusinessException {
		this.userUpdater.changePassword(changePasswordDto);
	}
}