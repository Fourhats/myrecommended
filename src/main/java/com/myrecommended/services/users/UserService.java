package com.myrecommended.services.users;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.services.users.dtos.ChangePasswordRequestDTO;
import com.myrecommended.services.users.dtos.LoggedUserDTO;
import com.myrecommended.services.users.dtos.UpdateUserRequestDTO;
import com.myrecommended.services.users.dtos.CurrentUserDTO;
import com.myrecommended.services.users.dtos.UserRequestDTO;
import com.restfb.types.User;

@Service
public interface UserService {

	LoggedUserDTO getFbLoggedUserByEmail(String email) throws MyRecommendedBusinessException;

	@Transactional
	LoggedUserDTO addUser(UserRequestDTO userDto) throws MyRecommendedBusinessException;

	@Transactional
	LoggedUserDTO addUser(User user) throws MyRecommendedBusinessException;

	@Transactional
	void updateUser(UpdateUserRequestDTO userDto) throws FileNotFoundException, IOException, Exception;

	@Transactional
	boolean existUserWithEmail(String email);

	CurrentUserDTO getUser(long userId);

	@Transactional
	void changePassword(ChangePasswordRequestDTO changePasswordDto) throws MyRecommendedBusinessException;

	String getUserAvatar(long userId);
}
