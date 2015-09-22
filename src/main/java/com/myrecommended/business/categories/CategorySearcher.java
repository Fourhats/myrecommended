package com.myrecommended.business.categories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.daos.CategoryDAO;
import com.myrecommended.models.Category;

@Component
public class CategorySearcher {

	@Autowired
	private CategoryDAO categoryDao;

	public List<Category> getAll() {
		return this.categoryDao.getAll();
	}
}
