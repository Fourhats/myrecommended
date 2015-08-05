package com.myrecommended.business.recommended.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class RecommendedCategorieslessException extends MyRecommendedBusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecommendedCategorieslessException(String message) {
		super(message);
	}
}