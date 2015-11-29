package com.myrecommended.business.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.business.questions.exceptions.AnswerHasEmptyDescriptionException;
import com.myrecommended.business.questions.exceptions.AnsweredNotOwnRecommendedQuestion;
import com.myrecommended.business.questions.exceptions.QuestionHasEmptyDescriptionException;
import com.myrecommended.business.questions.exceptions.QuestionIsNotValidException;
import com.myrecommended.business.users.exceptions.UserIsNotEnableException;
import com.myrecommended.business.users.exceptions.UserNotExistException;
import com.myrecommended.daos.QuestionDAO;
import com.myrecommended.daos.UserDAO;
import com.myrecommended.models.Question;
import com.myrecommended.models.User;
import com.myrecommended.services.questions.dtos.AnswerRequestDTO;
import com.myrecommended.services.questions.dtos.QuestionRequestDTO;

@Component
public class QuestionValidator {

	@Autowired
	private UserDAO userDao; 
	
	@Autowired
	private QuestionDAO questionDao;
	
	public void validateCanMakeQuestion(QuestionRequestDTO questionDto) throws MyRecommendedBusinessException {
		this.validateHasDescription(questionDto.getDescription());
		this.validateHasValidUser(questionDto.getUserId());
	}
	
	public void validateCanAnswerQuestion(AnswerRequestDTO answerDto) throws MyRecommendedBusinessException {
		this.validateHasAnswer(answerDto.getDescription());
		this.validateHasValidUser(answerDto.getUserId());
		
		Question question = this.questionDao.getById(answerDto.getQuestionId());
		this.validateIsValidQuestion(question);
		this.validateIsAnswerOwnRecommendedQuestion(question.getUser().getId(), answerDto.getUserId());
	}
	
	private void validateHasValidUser(long userId) throws UserNotExistException, UserIsNotEnableException {
		User user = this.userDao.getById(userId);
		if(user  == null) {
			throw new UserNotExistException("No existe el usuario");
		} else if(!user.isEnable()) {
			throw new UserIsNotEnableException();
		}
	}
	
	//QUESTION VALIDATIONS
	private void validateHasDescription(String description) throws QuestionHasEmptyDescriptionException {
		if(description == null || description.isEmpty()) {
			throw new QuestionHasEmptyDescriptionException("La pregunta no puede ser vacia");
		}
	}
	
	//ANSWER VALIDATIONS
	private void validateHasAnswer(String description) throws AnswerHasEmptyDescriptionException {
		if(description == null || description.isEmpty()) {
			throw new AnswerHasEmptyDescriptionException("La respuesta no puede ser vacia");
		}
	}
	
	private void validateIsValidQuestion(Question question) throws QuestionIsNotValidException {
		if(question == null) {
			throw new QuestionIsNotValidException("La pregunta no existe");
		}
	}
	
	private void validateIsAnswerOwnRecommendedQuestion(long questionUserId, long userId) throws AnsweredNotOwnRecommendedQuestion {
		if(questionUserId != userId) {
			throw new AnsweredNotOwnRecommendedQuestion("La pregunta no es valida");
		}
	}
}