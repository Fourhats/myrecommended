package com.myrecommended.business.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.business.emails.EmailManager;
import com.myrecommended.daos.UserDAO;
import com.myrecommended.models.User;
import com.myrecommended.services.users.dtos.UserRequestDTO;

@Component
public class UserGenerator {

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private UserFactory userFactory;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private EmailManager emailManager;
	
	public User generate(UserRequestDTO userDto) throws MyRecommendedBusinessException {
		this.userValidator.validateIfCanBeCreated(userDto);
		User user = this.userFactory.Create(userDto);
		this.userDao.add(user);
		
		emailManager.SendUserRegistrationEmail(user.getName(), user.getEmail());
		
		return user;
	}

	public User generate(com.restfb.types.User fbUser) throws MyRecommendedBusinessException {
		this.userValidator.validateIfCanBeCreated(fbUser);
		User user = this.userFactory.Create(fbUser);
		this.userDao.add(user);
		
		emailManager.SendUserRegistrationEmail(user.getName(), user.getEmail());
		
		return user;
	}
}