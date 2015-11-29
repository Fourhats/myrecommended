package com.myrecommended.business.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.daos.AnswerDAO;
import com.myrecommended.daos.QuestionDAO;
import com.myrecommended.models.Answer;
import com.myrecommended.models.Question;
import com.myrecommended.services.questions.dtos.AnswerRequestDTO;
import com.myrecommended.services.questions.dtos.QuestionRequestDTO;

@Component
public class Questioner {

	@Autowired
	private QuestionFactory questionFactory;
	
	@Autowired
	private AnswerFactory answerFactory;
	
	@Autowired
	private QuestionValidator questionValidator;

	@Autowired
	private QuestionDAO questionDao;
	
	@Autowired
	private AnswerDAO answerDao;
		
	public Question MakeQuestion(QuestionRequestDTO questionDto) throws MyRecommendedBusinessException {
		this.questionValidator.validateCanMakeQuestion(questionDto);
		Question question = this.questionFactory.Create(questionDto);
		this.questionDao.add(question);
		
		return question;
	}

	public void answerQuestion(AnswerRequestDTO answerDto) throws MyRecommendedBusinessException {
		this.questionValidator.validateCanAnswerQuestion(answerDto);
		Answer answer = this.answerFactory.Create(answerDto);
		this.answerDao.add(answer);
	}
}