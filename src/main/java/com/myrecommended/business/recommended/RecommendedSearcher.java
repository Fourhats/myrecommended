package com.myrecommended.business.recommended;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.daos.RecommendedDAO;
import com.myrecommended.models.Page;
import com.myrecommended.models.Recommended;

@Component
public class RecommendedSearcher {

	@Autowired
	private RecommendedDAO recommendedDao;
	
	public List<Recommended> getAll() {
		return this.recommendedDao.getAll();
	}
	
	public Page<Recommended> getPage(int pageIndex, int pageSize, List<Long> categoriesFiltered) {
		return this.recommendedDao.getRecommendedsPage(pageIndex, pageSize, categoriesFiltered);
	}

	public Page<Recommended> getRecommendedsPageByCategoryAndKeyword(int pageIndex, int pageSize, long categoryId, String recommendedKey) {
		return this.recommendedDao.getRecommendedsPageByCategoryAndKeyword(pageIndex, pageSize, categoryId, recommendedKey);	
	}

	public Recommended getById(long recommendedId) {
		return this.recommendedDao.getById(recommendedId);
	}

	public Recommended getByUserId(Long userId) {
		return this.recommendedDao.getByUserId(userId);
	}

	public boolean existByUserId(Long userId) {
		return this.recommendedDao.existByUserId(userId);
	}

	public String getRecommendedAvatarByUser(long userId) {
		Recommended recommended = this.recommendedDao.getByUserId(userId);
		if(recommended != null) {
			return recommended.getAvatarName();
		}
		
		return null;
	}
}