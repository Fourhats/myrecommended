package com.myrecommended.business.recommended;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.recommended.factories.RecommendedImageFactory;
import com.myrecommended.daos.CategoryDAO;
import com.myrecommended.daos.UserDAO;
import com.myrecommended.models.Category;
import com.myrecommended.models.Recommended;
import com.myrecommended.models.RecommendedImage;
import com.myrecommended.models.User;
import com.myrecommended.services.recommended.dtos.RecommendedRequestDTO;

@Component
public class RecommendedFactory {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private RecommendedImageFactory recommendedImageFactory;
	
	public Recommended create(RecommendedRequestDTO recommendedDto) {
		User user = this.userDao.getById(recommendedDto.getUserId());
		List<Category> categories = this.categoryDAO.getByIds(recommendedDto.getCategoryIds());
		List<RecommendedImage> recommendedImages = this.recommendedImageFactory.create(recommendedDto.getRecommendedImages());
		
		return new Recommended(user, new HashSet<Category>(categories), recommendedDto.getName(), 
				recommendedDto.getDescription(), recommendedDto.getEmail(), new HashSet<RecommendedImage>(recommendedImages));
	}
}