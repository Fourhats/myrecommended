package com.myrecommended.daos;

import java.util.Date;
import java.util.List;

import com.myrecommended.models.Answer;

public interface AnswerDAO extends BaseDAO<Answer, Long> {

	List<Answer> getAnswersByQuestionId(long questionId);

	boolean hasAnswers(long questionId);

	boolean hasAnswersSince(Long questionId, Date date);

}