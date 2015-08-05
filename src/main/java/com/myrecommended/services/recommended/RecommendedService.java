package com.myrecommended.services.recommended;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonElement;
import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.models.Page;
import com.myrecommended.services.recommended.dtos.RecommendedDTO;
import com.myrecommended.services.recommended.dtos.RecommendedRequestDTO;

@Service
public interface RecommendedService {

	@Transactional
	public RecommendedDTO addRecommended(RecommendedRequestDTO recommendedDto) throws MyRecommendedBusinessException;

	@Transactional
	public Page<RecommendedDTO> getRecommendedsPage(int pageIndex, int pageSize, List<Long> categoriesFiltered);

	@Transactional
	public Page<RecommendedDTO> getRecommendedsPageByKeyword(int pageIndex, int pageSize,String recommendedKey);
}