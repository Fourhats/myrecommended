package com.myrecommended.daos;

import java.util.List;

import com.myrecommended.models.Page;
import com.myrecommended.models.Question;

public interface QuestionDAO extends BaseDAO<Question, Long> {
	
	 Page<Question> getQuestions(int pageIndex, int pageSize, long entityId);

	 List<Question> getQuestionByUser(long userId);
	 
	 List<Question> getQuestionsByQuestionableEntityIds(List<Long> questionableEntityIds);
}
