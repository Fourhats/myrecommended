package com.myrecommended.services.petitions.dtos;

import java.util.Date;

import com.myrecommended.services.categories.dtos.CategoryDTO;
import com.myrecommended.services.users.dtos.CurrentUserDTO;
import com.myrecommended.services.utils.MyRecommendedBaseDTO;

public class PetitionDTO extends MyRecommendedBaseDTO {

	private Long id;
	
	private CurrentUserDTO user;
	
	private CategoryDTO category;
	
	private String title;
	
	private String description;
	
	private Date initialDate;
	
	private String address;

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