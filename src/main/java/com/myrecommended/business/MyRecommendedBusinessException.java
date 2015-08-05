package com.myrecommended.business;

public abstract class MyRecommendedBusinessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyRecommendedBusinessException() {
	}
	
	public MyRecommendedBusinessException(String message) {
		super(message);
	}
}
