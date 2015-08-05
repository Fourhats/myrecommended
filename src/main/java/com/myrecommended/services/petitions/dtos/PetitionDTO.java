package com.myrecommended.services.petitions.dtos;

import java.util.Date;

import com.myrecommended.services.categories.dtos.CategoryDTO;
import com.myrecommended.services.users.dtos.UserDTO;

public class PetitionDTO {

	private String error;
	
	private Long id;
	
	private UserDTO user;
	
	private CategoryDTO category;
	
	private String title;
	
	private String description;
	
	private Date initialDate;
	
	private String address;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}