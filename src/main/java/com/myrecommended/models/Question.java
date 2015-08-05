package com.myrecommended.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question extends PersistibleEntity {
	
	public Question() {
	}
	
	public Question(String description, QuestionableObject questionableObject, User user) {
		this.description = description;
		this.questionableObject = questionableObject;
		this.user = user;
		this.date = new Date();
	}
	
	@Column(name="description")
	private String description;
	
	@Column(name="date")
	private Date date;
	
	@ManyToOne
    @JoinColumn(name="questionableObjectId")
	private QuestionableObject questionableObject;

	@ManyToOne
    @JoinColumn(name="userId")
	private User user;
	
	@OneToMany(mappedBy = "question")
    private Set<Answer> answers;
	
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

	public QuestionableObject getQuestionableObject() {
		return questionableObject;
	}

	public void setQuestionableObject(QuestionableObject questionableObject) {
		this.questionableObject = questionableObject;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
}
