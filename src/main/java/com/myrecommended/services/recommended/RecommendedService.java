package com.myrecommended.services.recommended;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.models.Page;
import com.myrecommended.services.recommended.dtos.HireRecommendedRequestDTO;
import com.myrecommended.services.recommended.dtos.RecommendedDTO;
import com.myrecommended.services.recommended.dtos.RecommendedFeedbackRequestDTO;
import com.myrecommended.services.recommended.dtos.RecommendedHiredDTO;
import com.myrecommended.services.recommended.dtos.RecommendedRequestDTO;

@Service
public interface RecommendedService {
	
	@Transactional
	void createOrUpdate(RecommendedRequestDTO recommendedDto) throws MyRecommendedBusinessException, FileNotFoundException, IOException, Exception;
	
	@Transactional
	Page<RecommendedDTO> getRecommendedsPage(int pageIndex, int pageSize, List<Long> categoriesFiltered);

	@Transactional
	Page<RecommendedDTO> getRecommendedsPageByCategoryAndKeyword(int pageIndex, int pageSize, long categoryId, String recommendedKey);

	@Transactional
	RecommendedDTO getRecommendedById(long recommendedId, long currentUserId);

	@Transactional
	RecommendedDTO getRecommendedByUserId(Long userId);

	String getRecommendedAvatarByUser(long userId);

	@Transactional
	void hireRecommended(HireRecommendedRequestDTO hireRecommendedDto);

	@Transactional
	void giveFeedbackToRecommended(RecommendedFeedbackRequestDTO recommendedFeedbackDto);

	@Transactional
	void giveFeedbackToUser(RecommendedFeedbackRequestDTO recommendedFeedbackDto);

	@Transactional
	Page<RecommendedHiredDTO> getRecommendedHired(long userId);

	@Transactional
	Page<RecommendedHiredDTO> getCustomers(long recommendedId);
}