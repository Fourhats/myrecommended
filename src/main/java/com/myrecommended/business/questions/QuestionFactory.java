package com.myrecommended.business.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.daos.UserDAO;
import com.myrecommended.models.Question;
import com.myrecommended.models.QuestionableObject;
import com.myrecommended.models.User;
import com.myrecommended.services.questions.dtos.QuestionRequestDTO;

@Component
public class QuestionFactory {

	@Autowired
	private QuestionableObjectGenerator questionableObjectGenerator;
	
	@Autowired
	private UserDAO userDAO;
	
	public Question Create(QuestionRequestDTO questionDto) {
		QuestionableObject questionableObject = this.questionableObjectGenerator.generate(questionDto.getEntityId(), questionDto.getEntityType());
		User user = this.userDAO.getById(questionDto.getUserId());
		
		Question question = new Question(questionDto.getDescription(), questionableObject, user);
		
		return question;
	}
}
