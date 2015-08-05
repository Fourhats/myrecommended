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
	
	public Page<Recommended> getRecommendedsPage(int pageIndex, int pageSize, List<Long> categoriesFiltered) {
		return this.recommendedDao.getRecommendedsPage(pageIndex, pageSize, categoriesFiltered);
	}

	public Page<Recommended> getRecommendedsPageByKeyword(int pageIndex, int pageSize, String recommendedKey) {
		return this.recommendedDao.getRecommendedsPageByKeyword(pageIndex, pageSize, recommendedKey);
	}
}