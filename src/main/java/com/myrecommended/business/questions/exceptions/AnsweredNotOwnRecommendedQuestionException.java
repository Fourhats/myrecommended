package com.myrecommended.business.questions.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class AnsweredNotOwnRecommendedQuestionException extends MyRecommendedBusinessException {

	private static final long serialVersionUID = 1L;

	public AnsweredNotOwnRecommendedQuestionException(String message) {
		super(message);
	}
}