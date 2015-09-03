package com.myrecommended.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="recommended")
public class Recommended extends PersistibleEntity {

	public Recommended(){
	}

	public Recommended(User user, Set<Category> categories, String name, String description, String email, 
			String phone, String avatarName, Set<RecommendedImage> recommendedImages) {
		this.user = user;
		this.categories = categories;
		this.name = name;
		this.description = description;
		this.email = email;
		this.phone = phone;
		this.recommendedImages = recommendedImages;
		this.avatarName = avatarName;
		this.creationDate = new Date();
		this.updateDate = new Date();
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "recommended_category", 
		joinColumns = {  @JoinColumn(name = "recommended_id", nullable = false, updatable = false) }, 
		inverseJoinColumns = { @JoinColumn(name = "category_id",  nullable = false, updatable = false) }
	)
	private Set<Category> categories;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;

	@Column(name="avatarName")
	private String avatarName;
	
	@Column(name="creationDate")
	public Date creationDate;
	
	@Column(name="updateDate")
	public Date updateDate;
	
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="recommendedId")
	@OrderBy("isPrincipal DESC")
	private Set<RecommendedImage> recommendedImages;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvatarName() {
		return avatarName;
	}

	public void setAvatarName(String avatarName) {
		this.avatarName = avatarName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Set<RecommendedImage> getRecommendedImages() {
		return recommendedImages;
	}

	public void setRecommendedImages(Set<RecommendedImage> recommendedImages) {
		this.recommendedImages = recommendedImages;
	}
}