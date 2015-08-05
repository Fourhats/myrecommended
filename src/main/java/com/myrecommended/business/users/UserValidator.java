package com.myrecommended.business.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.business.users.exceptions.DuplicatedUserException;
import com.myrecommended.daos.UserDAO;
import com.myrecommended.models.User;
import com.myrecommended.services.users.dtos.UserRequestDTO;

@Component
public class UserValidator {

	@Autowired
	private UserDAO userDao;
	
	public void validateIfCanBeCreated(UserRequestDTO userRequestDTO) throws MyRecommendedBusinessException {
		this.validateDuplicatedEmail(userRequestDTO.getEmail());
		
		this.validateDuplicatedUsername(userRequestDTO.getUsername());
	}

	public void validateIfCanBeCreated(com.restfb.types.User fbUser) throws MyRecommendedBusinessException {
		this.validateDuplicatedEmail(fbUser.getEmail());
		
		this.validateDuplicatedUsername(fbUser.getEmail());
	}
	
	private void validateDuplicatedEmail(String email) throws DuplicatedUserException {
		if(this.userDao.getByEmail(email) != null) {
			throw new DuplicatedUserException("Ya existe un usuario con el email " + email);
		}
	}
	
	private void validateDuplicatedUsername(String username) throws DuplicatedUserException {
		if(this.userDao.getByUsername(username) != null) {
			throw new DuplicatedUserException("Ya existe un usuario con el nombre de usuario " + username);
		}
	}
}