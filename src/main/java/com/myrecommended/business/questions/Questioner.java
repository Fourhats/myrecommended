package com.myrecommended.business.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.daos.QuestionDAO;
import com.myrecommended.models.Question;
import com.myrecommended.services.questions.dtos.QuestionRequestDTO;

@Component
public class Questioner {

	@Autowired
	private QuestionFactory questionFactory;
	
	@Autowired
	private QuestionValidator questionValidator;

	@Autowired
	private QuestionDAO questionDao;
	
	public Question MakeQuestion(QuestionRequestDTO questionDto) throws MyRecommendedBusinessException {
		this.questionValidator.validateCanMakeQuestion(questionDto);
		Question question = this.questionFactory.Create(questionDto);
		this.questionDao.add(question);
		
		return question;
	}
}