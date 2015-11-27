package com.myrecommended.services.recommended.dtos;

import java.util.ArrayList;
import java.util.List;

import com.myrecommended.services.categories.dtos.CategoryDTO;
import com.myrecommended.services.users.dtos.CurrentUserDTO;
import com.myrecommended.services.utils.MyRecommendedBaseDTO;

public class RecommendedDTO extends MyRecommendedBaseDTO {

	private Long id;
	
	private CurrentUserDTO user;
	
	private String name;
	
	private String email;
	
	private Long phone;
	
	private String description;
	
	private String avatarName;
	
	private List<CategoryDTO> categories;
	
	private List<Long> categoryIds = new ArrayList<Long>();
	
	private List<RecommendedImageDTO> recommendedImages;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvatarName() {
		return avatarName;
	}

	public void setAvatarName(String avatarName) {
		this.avatarName = avatarName;
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