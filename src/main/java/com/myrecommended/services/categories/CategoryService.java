package com.myrecommended.services.categories;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myrecommended.services.categories.dtos.CategoryDTO;

@Service
public interface CategoryService {

	List<CategoryDTO> getAllCategories();

	List<Long> getCategoryIdsByKeyword(String recommendedKey);
}