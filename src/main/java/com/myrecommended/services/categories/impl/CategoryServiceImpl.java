package com.myrecommended.services.categories.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.myrecommended.business.categories.CategorySearcher;
import com.myrecommended.models.Category;
import com.myrecommended.services.categories.CategoryService;
import com.myrecommended.services.categories.dtos.CategoryDTO;
import com.myrecommended.services.utils.MapperUtil;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private Mapper mapper;
	
	@Autowired
	private CategorySearcher categorySearcher;
	
	public List<CategoryDTO> getAllCategories() {
		List<Category> categories = this.categorySearcher.getAll();
		return MapperUtil.map(mapper, categories, CategoryDTO.class);
	}
}