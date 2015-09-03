package com.myrecommended.daos;

import java.util.List;

import com.myrecommended.models.Category;

public interface CategoryDAO extends BaseDAO<Category, Long> {
	
	List<Category> getByIds(List<Long> categoryIds);

	List<Category> getCategoriesByKeyword(String recommendedKey);
	
	boolean existCategory(Long categoryId);
}