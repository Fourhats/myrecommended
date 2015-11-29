package com.myrecommended.business.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.daos.QuestionDAO;
import com.myrecommended.daos.UserDAO;
import com.myrecommended.models.Answer;
import com.myrecommended.models.Question;
import com.myrecommended.models.User;
import com.myrecommended.services.questions.dtos.AnswerRequestDTO;

@Component
public class AnswerFactory {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private QuestionDAO questionDAO;
	
	public Answer Create(AnswerRequestDTO answerDto) {
		User user = this.userDAO.getById(answerDto.getUserId());
		Question question = this.questionDAO.getById(answerDto.getQuestionId());

		Answer answer = new Answer(answerDto.getDescription(), question, user);
		return answer;
	}
}
