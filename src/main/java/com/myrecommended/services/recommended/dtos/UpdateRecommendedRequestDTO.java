package com.myrecommended.services.recommended.dtos;

import java.util.List;

public class UpdateRecommendedRequestDTO {

	private Long userId;
	
	private List<Long> categoryIds;
	
	private String name;
	
	private String description;
	
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
}
