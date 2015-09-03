package com.myrecommended.business.categories;

import java.util.ArrayList;
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

	//TODO: ver si el dao ya puede traer los ids
	public List<Long> getCategoryIdsByKeyword(String recommendedKey) {
		List<Category> categories = this.categoryDao.getCategoriesByKeyword(recommendedKey);
		List<Long> categoryIds = new ArrayList<Long>();
		for(Category category : categories) 
		{
			categoryIds.add(category.getId());
		}
		
		return categoryIds;
	}
}
