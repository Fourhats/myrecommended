package com.myrecommended.business.questions.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class QuestionHasAnAnswerException  extends MyRecommendedBusinessException {

	private static final long serialVersionUID = 1L;

	public QuestionHasAnAnswerException(String message) {
		super(message);
	}
	
	public QuestionHasAnAnswerException() {
		super("La pregunta ya tiene una respuesta");
	}
}