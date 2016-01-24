package com.myrecommended.business.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.business.emails.EmailManager;
import com.myrecommended.daos.AnswerDAO;
import com.myrecommended.daos.QuestionDAO;
import com.myrecommended.daos.RecommendedDAO;
import com.myrecommended.models.Answer;
import com.myrecommended.models.Question;
import com.myrecommended.models.Recommended;
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
	
	@Autowired
	private RecommendedDAO recommendedDao;
	
	@Autowired
	private EmailManager emailManager;
		
	public Question MakeQuestion(QuestionRequestDTO questionDto) throws MyRecommendedBusinessException {
		this.questionValidator.validateCanMakeQuestion(questionDto);
		Question question = this.questionFactory.Create(questionDto);
		this.questionDao.add(question);
		
		Recommended recommended = this.recommendedDao.getById(questionDto.getEntityId());
		this.emailManager.SendQuestionAskedEmail(question, recommended);
		
		return question;
	}

	public void answerQuestion(AnswerRequestDTO answerDto) throws MyRecommendedBusinessException {
		this.questionValidator.validateCanAnswerQuestion(answerDto);
		Answer answer = this.answerFactory.Create(answerDto);
		this.answerDao.add(answer);
		
		Recommended recommended = this.recommendedDao.getById(answer.getQuestion().getQuestionableObject().getEntityId());
		this.emailManager.SendQuestionAnsweredEmail(answer, recommended);
	}
}