package com.myrecommended.services.recommended.dtos;

import java.util.ArrayList;
import java.util.List;

import com.myrecommended.services.categories.dtos.CategoryDTO;
import com.myrecommended.services.users.dtos.CurrentUserDTO;

public class RecommendedDTO {

	private Long id;
	
	private String error;
	
	private CurrentUserDTO user;
	
	private String name;
	
	private String email;
	
	private Integer phone;
	
	private String description;
	
	private List<CategoryDTO> categories;
	
	private List<Long> categoryIds = new ArrayList<Long>();
	
	private List<RecommendedImageDTO> recommendedImages;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public CurrentUserDTO getUser() {
		return user;
	}

	public void setUser(CurrentUserDTO user) {
		this.user = user;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
		for(CategoryDTO category : categories) {
			this.categoryIds.add(category.getId());
		}
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
}