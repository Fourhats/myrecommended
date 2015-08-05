package com.myrecommended.daos;

import java.util.List;

import com.myrecommended.models.Question;

public interface QuestionDAO extends BaseDAO<Question, Long> {
	
	 List<Question> getQuestions(long entityId, int entityType);

	 List<Question> getQuestionByUser(long userId);
	 
	 List<Question> getQuestionsByQuestionableEntityIds(List<Long> questionableEntityIds);
}
