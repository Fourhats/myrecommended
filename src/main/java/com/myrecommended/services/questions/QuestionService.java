package com.myrecommended.services.questions;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.models.Page;
import com.myrecommended.services.questions.dtos.AnswerRequestDTO;
import com.myrecommended.services.questions.dtos.QuestionDTO;
import com.myrecommended.services.questions.dtos.QuestionRequestDTO;

@Service
public interface QuestionService {

	@Transactional
	QuestionDTO addQuestion(QuestionRequestDTO questionDto) throws MyRecommendedBusinessException;

	@Transactional
	void answerQuestion(AnswerRequestDTO answerDto) throws MyRecommendedBusinessException;

	@Transactional
	Page<QuestionDTO> getQuestions(long entityId, int pageIndex, int pageSize);
}