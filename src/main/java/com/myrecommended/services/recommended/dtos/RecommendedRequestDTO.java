package com.myrecommended.services.recommended.dtos;

import java.util.List;

public class RecommendedRequestDTO {

	private Long userId;
	
	private List<Long> categoryIds;
	
	private List<RecommendedImageDTO> recommendedImages;
	
	private List<String> recommendedImageNames;
	
	private String name;
	
	private String description;
	
	private String email;
	
	private Integer phone;
	
	private String avatarName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public List<RecommendedImageDTO> getRecommendedImages() {
		return recommendedImages;
	}

	public void setRecommendedImages(List<RecommendedImageDTO> recommendedImages) {
		this.recommendedImages = recommendedImages;
	}
	
	public List<String> getRecommendedImageNames() {
		return recommendedImageNames;
	}

	public void setRecommendedImageNames(List<String> recommendedImageNames) {
		this.recommendedImageNames = recommendedImageNames;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getAvatarName() {
		return avatarName;
	}

	public void setAvatarName(String avatarName) {
		this.avatarName = avatarName;
	}
}