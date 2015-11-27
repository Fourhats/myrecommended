package com.myrecommended.business.users.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class UserIsNotEnableException extends MyRecommendedBusinessException {

	private static final long serialVersionUID = 1L;

	public UserIsNotEnableException() {
		super("El usuario no esta activo");
	}
	
	public UserIsNotEnableException(String message) {
		super(message);
	}
}