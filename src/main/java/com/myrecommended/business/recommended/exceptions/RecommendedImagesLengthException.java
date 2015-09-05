package com.myrecommended.business.recommended.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class RecommendedImagesLengthException extends MyRecommendedBusinessException {

	private static final long serialVersionUID = 1L;

	public RecommendedImagesLengthException(String message) {
		super(message);
	}
}