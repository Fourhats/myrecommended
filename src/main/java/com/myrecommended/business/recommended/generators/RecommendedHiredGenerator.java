package com.myrecommended.business.recommended.generators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.recommended.factories.RecommendedHiredFactory;
import com.myrecommended.daos.RecommendedHiredDAO;
import com.myrecommended.models.RecommendedHired;
import com.myrecommended.services.recommended.dtos.HireRecommendedRequestDTO;

@Component
public class RecommendedHiredGenerator {
	
	@Autowired
	private RecommendedHiredFactory recommendedHiredFactory;
	
	@Autowired
	private RecommendedHiredDAO recommendedHiredDao;
	
	public void generate(HireRecommendedRequestDTO hireRecommendedDto) {
		RecommendedHired recommendedHired = this.recommendedHiredFactory.create(hireRecommendedDto);
		this.recommendedHiredDao.add(recommendedHired);
	}
}