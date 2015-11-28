package com.myrecommended.services.questions.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.business.questions.QuestionSearcher;
import com.myrecommended.business.questions.Questioner;
import com.myrecommended.models.Page;
import com.myrecommended.models.Question;
import com.myrecommended.services.questions.QuestionService;
import com.myrecommended.services.questions.dtos.AnswerRequestDTO;
import com.myrecommended.services.questions.dtos.QuestionDTO;
import com.myrecommended.services.questions.dtos.QuestionRequestDTO;
import com.myrecommended.services.utils.MapperUtil;

public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private Mapper mapper;
	
	@Autowired
	private Questioner questioner;
	
	@Autowired
	private QuestionSearcher questionSearcher;
	
	@Override
	public QuestionDTO addQuestion(QuestionRequestDTO questionDto) throws MyRecommendedBusinessException {
		Question question = this.questioner.MakeQuestion(questionDto);
		return MapperUtil.map(mapper, question, QuestionDTO.class);
	}

	@Override
	public void answerQuestion(AnswerRequestDTO answerDto) throws MyRecommendedBusinessException {
	}

	@Override
	public Page<QuestionDTO> getQuestions(long entityId, int pageIndex, int pageSize) {
		Page<Question> questionsPage = this.questionSearcher.getPage(pageIndex, pageSize, entityId);
		return MapperUtil.map(mapper, questionsPage, QuestionDTO.class);
	}
}