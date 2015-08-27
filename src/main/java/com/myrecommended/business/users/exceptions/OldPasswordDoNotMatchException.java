package com.myrecommended.business.users.exceptions;

import com.myrecommended.business.MyRecommendedBusinessException;

public class OldPasswordDoNotMatchException extends MyRecommendedBusinessException {

	private static final long serialVersionUID = 1L;

	public OldPasswordDoNotMatchException() {
		super("La contraseña no coincide con la actual");
	}
	
	public OldPasswordDoNotMatchException(String message) {
		super(message);
	}
}