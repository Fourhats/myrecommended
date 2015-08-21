package com.myrecommended.business.recommended.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class RecommendedAlreadyExistException extends MyRecommendedBusinessException {

	private static final long serialVersionUID = 1L;

	public RecommendedAlreadyExistException(String message) {
		super(message);
	}
}