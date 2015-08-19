package com.myrecommended.business.users.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class UserNotExistException extends MyRecommendedBusinessException {

	private static final long serialVersionUID = 1L;

	public UserNotExistException() {
		super();
	}
	
	public UserNotExistException(String message) {
		super(message);
	}
}
