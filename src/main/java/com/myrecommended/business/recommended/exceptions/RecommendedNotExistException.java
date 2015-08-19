package com.myrecommended.business.recommended.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class RecommendedNotExistException extends MyRecommendedBusinessException {

	private static final long serialVersionUID = 1L;

	public RecommendedNotExistException(String message) {
		super(message);
	}
}
