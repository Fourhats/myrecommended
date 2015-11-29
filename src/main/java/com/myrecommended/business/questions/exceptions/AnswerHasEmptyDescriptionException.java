package com.myrecommended.business.questions.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class AnswerHasEmptyDescriptionException extends MyRecommendedBusinessException {

	private static final long serialVersionUID = 1L;

	public AnswerHasEmptyDescriptionException(String message) {
		super(message);
	}
}