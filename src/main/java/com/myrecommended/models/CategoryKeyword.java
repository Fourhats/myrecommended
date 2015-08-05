package com.myrecommended.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="categoryKeyword")
public class CategoryKeyword extends PersistibleEntity {

	@Column(name = "keyword", length = 45)
	private String keyword;

	@ManyToOne
    @JoinColumn(name="categoryId")
	private Category category;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
