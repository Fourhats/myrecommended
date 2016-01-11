package com.myrecommended.services.recommended.dtos;

public class RecommendedFeedbackRequestDTO {

	private long recommendedHiredId;
	
	private String feedback;
	
	private int stars;

	public long getRecommendedHiredId() {
		return recommendedHiredId;
	}

	public void setRecommendedHiredId(long recommendedHiredId) {
		this.recommendedHiredId = recommendedHiredId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}
}