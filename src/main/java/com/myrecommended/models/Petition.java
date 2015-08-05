package com.myrecommended.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="petition")
public class Petition extends PersistibleEntity {

	public Petition(User user, Category category, String title, String description, Date initialDate, String address) {
		this.user = user;
		this.category = category;
		this.title = title;
		this.description = description;
		this.initialDate = initialDate;
		this.address = address;
		this.creationDate = new Date();
	}

	@ManyToOne
    @JoinColumn(name="userId")
	private User user;
	
	@ManyToOne
    @JoinColumn(name="categoryId")
	private Category category;
	
	@Column(name="title",nullable=false)
	private String title;
	
	@Column(name="description",nullable=false)
	private String description;
	
	@Column(name="initialDate",nullable=false)
	private Date initialDate;
	
	@Column(name="address",nullable=false)
	private String address;
	
	@Column(name="creationDate",nullable=false)
	private Date creationDate;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}