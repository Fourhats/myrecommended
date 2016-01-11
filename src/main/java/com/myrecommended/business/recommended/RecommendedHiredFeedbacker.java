package com.myrecommended.business.recommended;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.daos.RecommendedHiredDAO;
import com.myrecommended.models.RecommendedHired;
import com.myrecommended.services.recommended.dtos.RecommendedFeedbackRequestDTO;

@Component
public class RecommendedHiredFeedbacker {

	@Autowired
	private RecommendedHiredDAO recommendedHiredDao;
	
	public void GiveFeedbackToRecommended(RecommendedFeedbackRequestDTO recommendedFeedbackDTO) {
		//validate if exist and if user
		RecommendedHired recommendedHired = this.recommendedHiredDao.getById(recommendedFeedbackDTO.getRecommendedHiredId());
		recommendedHired.setRecommendedFeedback(recommendedFeedbackDTO.getFeedback());
		recommendedHired.setStar(recommendedFeedbackDTO.getStars());
		
		this.recommendedHiredDao.add(recommendedHired);
	}

	public void giveFeedbackToUser(RecommendedFeedbackRequestDTO recommendedFeedbackDTO) {
		//validate if exist and if user
		RecommendedHired recommendedHired = this.recommendedHiredDao.getById(recommendedFeedbackDTO.getRecommendedHiredId());
		recommendedHired.setUserFeedback(recommendedFeedbackDTO.getFeedback());
		
		this.recommendedHiredDao.add(recommendedHired);
	}
}
