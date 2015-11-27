package com.myrecommended.business.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.business.questions.exceptions.QuestionHasEmptyDescriptionException;
import com.myrecommended.business.users.exceptions.UserIsNotEnableException;
import com.myrecommended.business.users.exceptions.UserNotExistException;
import com.myrecommended.daos.UserDAO;
import com.myrecommended.models.User;
import com.myrecommended.services.questions.dtos.QuestionRequestDTO;

@Component
public class QuestionValidator {

	@Autowired
	private UserDAO userDao; 
	
	public void validateCanMakeQuestion(QuestionRequestDTO questionDto) throws MyRecommendedBusinessException {
		this.validateHasDescription(questionDto.getDescription());
		this.validateHasValidUser(questionDto.getUserId());
	}
	
	//QUESTION VALIDATIONS
	private void validateHasDescription(String description) throws QuestionHasEmptyDescriptionException {
		if(description == null || description.isEmpty()) {
			throw new QuestionHasEmptyDescriptionException("La pregunta no puede ser vacia");
		}
	}
	
	private void validateHasValidUser(long userId) throws UserNotExistException, UserIsNotEnableException {
		User user = this.userDao.getById(userId);
		if(user  == null) {
			throw new UserNotExistException("No existe el usuario");
		} else if(!user.isEnable()) {
			throw new UserIsNotEnableException();
		}
	}
}