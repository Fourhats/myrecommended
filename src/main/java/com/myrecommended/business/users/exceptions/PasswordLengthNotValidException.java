package com.myrecommended.business.users.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class PasswordLengthNotValidException extends MyRecommendedBusinessException {

	private static final long serialVersionUID = 1L;
	
	public PasswordLengthNotValidException(String message) {
		super(message);
	}
}