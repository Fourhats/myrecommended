package com.myrecommended.services.questions.dtos;

import java.util.Set;

import com.myrecommended.services.utils.MyRecommendedBaseDTO;

public class QuestionDTO extends MyRecommendedBaseDTO {

	private long id;
	
	private String description;
	
	private Set<AnswerDTO> answers;
	
	private boolean hasAnswer;
	
	private String userName;
	
	private String userSurname;
	
	private String fullName;
	
	private String userAvatarName;

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
	
	public Set<AnswerDTO> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<AnswerDTO> answers) {
		this.answers = answers;
		this.setHasAnswer(!answers.isEmpty());
	}

	public boolean isHasAnswer() {
		return hasAnswer;
	}

	public void setHasAnswer(boolean hasAnswer) {
		this.hasAnswer = hasAnswer;
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

	public String getUserAvatarName() {
		return userAvatarName;
	}

	public void setUserAvatarName(String userAvatarName) {
		this.userAvatarName = userAvatarName;
	}
}