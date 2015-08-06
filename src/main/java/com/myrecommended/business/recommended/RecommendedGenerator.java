package com.myrecommended.business.recommended;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.daos.RecommendedDAO;
import com.myrecommended.models.Recommended;
import com.myrecommended.services.recommended.dtos.RecommendedRequestDTO;

@Component
public class RecommendedGenerator {
	
	@Autowired
	private RecommendedFactory recommendedFactory;
	
	@Autowired
	private RecommendedDAO recommendedDao;
	
	@Autowired
	private RecommendedValidator recommendedValidator;
	
	public Recommended generate(RecommendedRequestDTO recommendedDto) throws MyRecommendedBusinessException {
		this.recommendedValidator.validate(recommendedDto);
		Recommended recommended = this.recommendedFactory.create(recommendedDto);
		this.recommendedDao.add(recommended);
		return recommended;
	}
}