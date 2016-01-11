package com.myrecommended.services.recommended.dtos;

public class HireRecommendedRequestDTO {
	
	private long recommendedId;
	
	private long userId;

	public long getRecommendedId() {
		return recommendedId;
	}

	public void setRecommendedId(long recommendedId) {
		this.recommendedId = recommendedId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}