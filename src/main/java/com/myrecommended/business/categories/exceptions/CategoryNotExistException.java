package com.myrecommended.business.categories.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class CategoryNotExistException extends MyRecommendedBusinessException {

	private static final long serialVersionUID = 1L;

	public CategoryNotExistException(String message) {
		super(message);
	}
}
