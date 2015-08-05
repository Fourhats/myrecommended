package com.myrecommended.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="answer")
public class Answer extends PersistibleEntity {
	
	public Answer() {
	}
	
	public Answer(String description, Question question, User user) {
		this.description = description;
		this.question = question;
		this.user = user;
		this.date = new Date();
	}
	
	@Column(name="description")
	private String description;
	
	@Column(name="date")
	private Date date;
	
	@ManyToOne
    @JoinColumn(name="questionId")
	private Question question;

	@ManyToOne
    @JoinColumn(name="userId")
	private User user;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}