package com.myrecommended.business.recommended;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.daos.CategoryDAO;
import com.myrecommended.daos.RecommendedDAO;
import com.myrecommended.models.Category;
import com.myrecommended.models.Recommended;
import com.myrecommended.services.recommended.dtos.UpdateRecommendedRequestDTO;

@Component
public class RecommendedUpdater {

	@Autowired
	private RecommendedFactory recommendedFactory;
	
	@Autowired
	private RecommendedDAO recommendedDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private RecommendedValidator recommendedValidator;
	
	public void update(UpdateRecommendedRequestDTO recommendedDto) throws MyRecommendedBusinessException {
		this.recommendedValidator.validateIfCanUpdate(recommendedDto);
		
		Recommended recommended = this.recommendedDAO.getByUserId(recommendedDto.getUserId());
		Set<Category> categories = new HashSet<Category>(this.categoryDAO.getByIds(recommendedDto.getCategoryIds()));
		
		recommended.setCategories(categories);
		recommended.setDescription(recommendedDto.getDescription());
		recommended.setName(recommendedDto.getName());
		recommended.setUpdateDate(new Date());
		
		this.recommendedDAO.add(recommended);
	}
}