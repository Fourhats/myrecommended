package com.myrecommended.services.recommended.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.business.recommended.RecommendedGenerator;
import com.myrecommended.business.recommended.RecommendedSearcher;
import com.myrecommended.business.recommended.RecommendedUpdater;
import com.myrecommended.models.Page;
import com.myrecommended.models.Recommended;
import com.myrecommended.services.recommended.RecommendedService;
import com.myrecommended.services.recommended.dtos.RecommendedDTO;
import com.myrecommended.services.recommended.dtos.RecommendedRequestDTO;
import com.myrecommended.services.recommended.dtos.UpdateRecommendedRequestDTO;
import com.myrecommended.services.utils.MapperUtil;

public class RecommendedServiceImpl implements RecommendedService {

	@Autowired
	private Mapper mapper;
	
	@Autowired
	private RecommendedGenerator recommendedGenerator;
	
	@Autowired
	private RecommendedSearcher recommendedSearcher;
	
	@Autowired
	private RecommendedUpdater recommendedUpdater;
	
	public RecommendedDTO addRecommended(RecommendedRequestDTO recommendedDto) throws MyRecommendedBusinessException {
		Recommended recommended = this.recommendedGenerator.generate(recommendedDto);
		return MapperUtil.map(mapper, recommended, RecommendedDTO.class);
	}
	
	public void updateRecommneded(UpdateRecommendedRequestDTO recommendedDto) throws MyRecommendedBusinessException {
		this.recommendedUpdater.update(recommendedDto);
	}

	public Page<RecommendedDTO> getRecommendedsPage(int pageIndex, int pageSize, List<Long> categoriesFiltered) {
		Page<Recommended> recommededsPage = this.recommendedSearcher.getRecommendedsPage(pageIndex, pageSize, categoriesFiltered);
		return MapperUtil.map(mapper, recommededsPage, RecommendedDTO.class);
	}

	public Page<RecommendedDTO> getRecommendedsPageByKeyword(int pageIndex, int pageSize, String recommendedKey) {
		Page<Recommended> recommededsPage = this.recommendedSearcher.getRecommendedsPageByKeyword(pageIndex, pageSize, recommendedKey);
		return MapperUtil.map(mapper, recommededsPage, RecommendedDTO.class);
	}

	public RecommendedDTO getRecommendedById(long recommendedId) {
		Recommended recommeded = this.recommendedSearcher.getRecommendedById(recommendedId);
		return MapperUtil.map(mapper, recommeded, RecommendedDTO.class);
	}
}