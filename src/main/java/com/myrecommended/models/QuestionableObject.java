package com.myrecommended.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="questionableObject")
public class QuestionableObject extends PersistibleEntity {

	public QuestionableObject() {
	}
	
	public QuestionableObject(long entityId, int entityType) {
		super();
		this.entityId = entityId;
		this.entityType = entityType;
	}

	@Column(name="entityId")
	private long entityId;
	
	@Column(name="entityType")
	private int entityType;
	
	@OneToMany(mappedBy = "questionableObject")
    private Set<Question> questions;

	public long getEntityId() {
		return entityId;
	}

	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}

	public int getEntityType() {
		return entityType;
	}

	public void setEntityType(int entityType) {
		this.entityType = entityType;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
}
