package com.myrecommended.services.questions.dtos;

import java.util.Set;

import com.myrecommended.services.users.dtos.BaseUserDTO;
import com.myrecommended.services.utils.MyRecommendedBaseDTO;

public class QuestionDTO extends MyRecommendedBaseDTO {

	private long id;
	
	private String description;
	
	private Set<AnswerDTO> answers;
	
	private boolean hasAnswer;
	
	private BaseUserDTO user;

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

	public BaseUserDTO getUser() {
		return user;
	}

	public void setUser(BaseUserDTO user) {
		this.user = user;
	}
}