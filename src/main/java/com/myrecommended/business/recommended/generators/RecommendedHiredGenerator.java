package com.myrecommended.business.recommended.generators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.emails.EmailManager;
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
	
	@Autowired
	private EmailManager emailManager;
	
	public void generate(HireRecommendedRequestDTO hireRecommendedDto) {
		RecommendedHired recommendedHired = this.recommendedHiredFactory.create(hireRecommendedDto);
		this.recommendedHiredDao.add(recommendedHired);
		
		this.emailManager.SendRecommendedHiredEmail(recommendedHired.getUser(), recommendedHired.getRecommended());
		this.emailManager.SendCustomerHireEmail(recommendedHired.getUser(), recommendedHired.getRecommended());
	}
}