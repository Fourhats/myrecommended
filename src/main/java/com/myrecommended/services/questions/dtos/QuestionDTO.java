package com.myrecommended.services.questions.dtos;

import com.myrecommended.services.utils.MyRecommendedBaseDTO;

public class QuestionDTO extends MyRecommendedBaseDTO {

	private long id;
	
	private String description;
	
	private String userName;
	
	private String userSurname;
	
	private String fullName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
		this.setFullName(this.userName + " " + this.userSurname);
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}