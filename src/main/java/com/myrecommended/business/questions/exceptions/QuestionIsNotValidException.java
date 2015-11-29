package com.myrecommended.business.questions.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class QuestionIsNotValidException extends MyRecommendedBusinessException {

	private static final long serialVersionUID = 1L;

	public QuestionIsNotValidException(String message) {
		super(message);
	}
}