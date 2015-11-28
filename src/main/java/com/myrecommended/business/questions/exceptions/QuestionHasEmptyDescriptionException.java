package com.myrecommended.business.questions.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class QuestionHasEmptyDescriptionException extends MyRecommendedBusinessException {

	private static final long serialVersionUID = 1L;

	public QuestionHasEmptyDescriptionException(String message) {
		super(message);
	}
}