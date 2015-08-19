package com.myrecommended.services.recommended;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.models.Page;
import com.myrecommended.services.recommended.dtos.RecommendedDTO;
import com.myrecommended.services.recommended.dtos.RecommendedRequestDTO;
import com.myrecommended.services.recommended.dtos.UpdateRecommendedRequestDTO;

@Service
public interface RecommendedService {

	@Transactional
	RecommendedDTO addRecommended(RecommendedRequestDTO recommendedDto) throws MyRecommendedBusinessException;

	@Transactional
	void updateRecommneded(UpdateRecommendedRequestDTO recommendedDto) throws MyRecommendedBusinessException;
	
	@Transactional
	Page<RecommendedDTO> getRecommendedsPage(int pageIndex, int pageSize, List<Long> categoriesFiltered);

	@Transactional
	Page<RecommendedDTO> getRecommendedsPageByKeyword(int pageIndex, int pageSize,String recommendedKey);

	@Transactional
	RecommendedDTO getRecommendedById(long recommendedId);
}