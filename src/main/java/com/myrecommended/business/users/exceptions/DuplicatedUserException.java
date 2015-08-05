package com.myrecommended.business.users.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class DuplicatedUserException extends MyRecommendedBusinessException {

	private static final long serialVersionUID = 1L;

	public DuplicatedUserException() {
		super();
	}
	
	public DuplicatedUserException(String message) {
		super(message);
	}
}