package com.myrecommended.business.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.users.exceptions.DuplicatedUserException;
import com.myrecommended.daos.UserDAO;
import com.myrecommended.models.User;

@Component
public class UserSearcher {

	@Autowired
	private UserDAO userDAO;
	
	public boolean existUserWithEmail(String email) {
		return this.userDAO.existUser(email);
	}

	public User getFbLoggedUserByEmail(String email) throws DuplicatedUserException {
		User user = this.userDAO.getByEmail(email);
		
		//TODO: pasar a un validator
		if(user.getSignInProvider() == null || !user.getSignInProvider().equals("FACEBOOK")) {
			throw new DuplicatedUserException("Ya existe un usuario con el email " + email);
		}
		
		return user;
	}

	public User getUser(long userId) {
		return this.userDAO.getById(userId);
	}
}
