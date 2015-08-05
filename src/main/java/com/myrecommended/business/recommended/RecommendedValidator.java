package com.myrecommended.business.recommended;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.business.recommended.exceptions.RecommendedAlreadyExiste;
import com.myrecommended.business.recommended.exceptions.RecommendedCategorieslessException;
import com.myrecommended.daos.RecommendedDAO;
import com.myrecommended.services.recommended.dtos.RecommendedRequestDTO;

@Component
public class RecommendedValidator {

	@Autowired
	private RecommendedDAO recommendedDao;
	
	public void validate(RecommendedRequestDTO recommendedDto) throws MyRecommendedBusinessException {
		if(this.recommendedDao.existByUserId(recommendedDto.getUserId())) {
			throw new RecommendedAlreadyExiste("Ya existe este recomendado");
		}
		
		if(recommendedDto.getCategoryIds().isEmpty()) {
			throw new RecommendedCategorieslessException("El recomendado no tiene categoria");
		}
	}
}
