package com.myrecommended.services.recommended.dtos;

import java.util.List;

import com.myrecommended.services.categories.dtos.CategoryDTO;
import com.myrecommended.services.users.dtos.UserDTO;

public class RecommendedDTO {

	private String error;
	
	private UserDTO user;
	
	private String name;
	
	private String description;
	
	private List<CategoryDTO> categories;
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
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

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}
}