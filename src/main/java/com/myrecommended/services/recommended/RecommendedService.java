package com.myrecommended.services.recommended;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.models.Page;
import com.myrecommended.services.recommended.dtos.RecommendedDTO;
import com.myrecommended.services.recommended.dtos.RecommendedRequestDTO;

@Service
public interface RecommendedService {
	
	@Transactional
	void createOrUpdate(RecommendedRequestDTO recommendedDto) throws MyRecommendedBusinessException, FileNotFoundException, IOException, Exception;
	
	@Transactional
	Page<RecommendedDTO> getRecommendedsPage(int pageIndex, int pageSize, List<Long> categoriesFiltered);

	@Transactional
	Page<RecommendedDTO> getRecommendedsPageByKeyword(int pageIndex, int pageSize,String recommendedKey);

	@Transactional
	RecommendedDTO getRecommendedById(long recommendedId);

	@Transactional
	RecommendedDTO getRecommendedByUserId(Long userId);

	String getRecommendedAvatarByUser(long userId);
}