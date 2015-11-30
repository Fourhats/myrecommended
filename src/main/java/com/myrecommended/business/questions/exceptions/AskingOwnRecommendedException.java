package com.myrecommended.business.questions.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class AskingOwnRecommendedException  extends MyRecommendedBusinessException {

	private static final long serialVersionUID = 1L;

	public AskingOwnRecommendedException(String message) {
		super(message);
	}
	
	public AskingOwnRecommendedException() {
		super("No puedes preguntar tu propia publicación");
	}
}