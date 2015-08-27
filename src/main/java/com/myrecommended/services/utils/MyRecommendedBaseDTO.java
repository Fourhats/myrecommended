package com.myrecommended.services.utils;

public class MyRecommendedBaseDTO {

	private String error;
	
	private boolean hasError;
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
		this.hasError = !this.error.isEmpty();
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}
}