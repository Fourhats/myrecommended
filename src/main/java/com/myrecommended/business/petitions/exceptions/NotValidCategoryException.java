package com.myrecommended.business.petitions.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class NotValidCategoryException extends MyRecommendedBusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotValidCategoryException(String message) {
		super(message);
	}
}