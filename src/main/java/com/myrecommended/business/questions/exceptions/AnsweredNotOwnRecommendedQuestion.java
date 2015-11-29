package com.myrecommended.business.questions.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class AnsweredNotOwnRecommendedQuestion extends MyRecommendedBusinessException {

	private static final long serialVersionUID = 1L;

	public AnsweredNotOwnRecommendedQuestion(String message) {
		super(message);
	}
}