package com.myrecommended.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category extends PersistibleEntity {

	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "description", length = 500)
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	private Set<Recommended> recommended;
	
	@OneToMany(mappedBy = "category")
	private Set<CategoryKeyword> categoryKeywords;

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

	public Set<Recommended> getRecommended() {
		return recommended;
	}

	public void setRecommended(Set<Recommended> recommended) {
		this.recommended = recommended;
	}

	public Set<CategoryKeyword> getCategoryKeywords() {
		return categoryKeywords;
	}

	public void setCategoryKeywords(Set<CategoryKeyword> categoryKeywords) {
		this.categoryKeywords = categoryKeywords;
	}
}