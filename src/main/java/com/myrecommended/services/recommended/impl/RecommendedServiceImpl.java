package com.myrecommended.services.recommended.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.business.recommended.RecommendedGenerator;
import com.myrecommended.business.recommended.RecommendedSearcher;
import com.myrecommended.business.recommended.RecommendedUpdater;
import com.myrecommended.constants.TempFolders;
import com.myrecommended.models.Page;
import com.myrecommended.models.Recommended;
import com.myrecommended.services.recommended.RecommendedService;
import com.myrecommended.services.recommended.dtos.RecommendedDTO;
import com.myrecommended.services.recommended.dtos.RecommendedRequestDTO;
import com.myrecommended.services.utils.FileHelper;
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
	
	@Value("#{configProps}")
	private Properties properties;
	
	public void createOrUpdate(RecommendedRequestDTO recommendedDto) throws MyRecommendedBusinessException, FileNotFoundException, IOException, Exception {

		if(this.recommendedSearcher.existByUserId(recommendedDto.getUserId())) {
			this.recommendedUpdater.update(recommendedDto);	
		} else {
			this.recommendedGenerator.generate(recommendedDto);
		}
		
		String tempPath = properties.getProperty("folder.temp");
		String recommendedOldJobsPath = properties.getProperty("folder.recommendedOldJobs");
		String recommendedAvatarsPath = properties.getProperty("folder.recommendedAvatars");
		
		FileHelper.generateImagesWithDifferentSizes(recommendedDto.getRecommendedImageNames(), tempPath, TempFolders.RECOMMENDED_OLD_JOBS_FOLDER.getValue(), recommendedOldJobsPath);
		FileHelper.generateImagesWithDifferentSizes(recommendedDto.getAvatarName(), tempPath, TempFolders.RECOMMENDED_AVATARS_FOLDER.getValue(), recommendedAvatarsPath);
	}

	public Page<RecommendedDTO> getRecommendedsPage(int pageIndex, int pageSize, List<Long> categoriesFiltered) {
		Page<Recommended> recommendedsPage = this.recommendedSearcher.getPage(pageIndex, pageSize, categoriesFiltered);
		return MapperUtil.map(mapper, recommendedsPage, RecommendedDTO.class);
	}

	public Page<RecommendedDTO> getRecommendedsPageByKeyword(int pageIndex, int pageSize, String recommendedKey) {
		Page<Recommended> recommendedsPage = this.recommendedSearcher.getPageByKeyword(pageIndex, pageSize, recommendedKey);
		return MapperUtil.map(mapper, recommendedsPage, RecommendedDTO.class);
	}

	public RecommendedDTO getRecommendedById(long recommendedId) {
		Recommended recommended = this.recommendedSearcher.getById(recommendedId);
		return MapperUtil.map(mapper, recommended, RecommendedDTO.class);
	}

	public RecommendedDTO getRecommendedByUserId(Long userId) {
		Recommended recommended = this.recommendedSearcher.getByUserId(userId);
		if (recommended == null) {
			return null;
		}
		
		return MapperUtil.map(mapper, recommended, RecommendedDTO.class);
	}

	public String getRecommendedAvatarByUser(long userId) {
		return this.recommendedSearcher.getRecommendedAvatarByUser(userId);
	}
}