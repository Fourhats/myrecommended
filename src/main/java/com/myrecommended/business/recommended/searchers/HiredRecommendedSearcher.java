package com.myrecommended.business.recommended.searchers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.daos.RecommendedHiredDAO;
import com.myrecommended.models.Page;
import com.myrecommended.models.RecommendedHired;

@Component
public class HiredRecommendedSearcher {

	@Autowired
	private RecommendedHiredDAO recommendedHiredDao;
	
	public Page<RecommendedHired> getRecommendedHired(int pageIndex, int pageSize, long userId) {
		return this.recommendedHiredDao.getRecommendedHired(pageIndex, pageSize, userId);
	}

	public Page<RecommendedHired> getCustomers(int pageIndex, int pageSize, long recommendedId) {
		return this.recommendedHiredDao.getCustomers(pageIndex, pageSize, recommendedId);
	}
}
