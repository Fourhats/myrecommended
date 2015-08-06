package com.myrecommended.services.users;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.services.users.dtos.LoggedUserDTO;
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
	boolean existUserWithEmail(String email);
}