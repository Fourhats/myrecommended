package com.myrecommended.daos;

import java.util.List;

import com.myrecommended.models.Category;

public interface CategoryDAO extends BaseDAO<Category, Long> {
	
	List<Category> getByIds(List<Long> categoryIds);

	boolean existCategory(Long categoryId);
	
}
