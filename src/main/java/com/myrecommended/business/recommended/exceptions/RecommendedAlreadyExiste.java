package com.myrecommended.business.recommended.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class RecommendedAlreadyExiste extends MyRecommendedBusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecommendedAlreadyExiste(String message) {
		super(message);
	}
}