package com.myrecommended.daos;

import com.myrecommended.models.Page;
import com.myrecommended.models.RecommendedHired;

public interface RecommendedHiredDAO extends BaseDAO<RecommendedHired, Long> {

	Page<RecommendedHired> getRecommendedHired(int pageIndex, int pageSize, long userId);

	Page<RecommendedHired> getCustomers(int pageIndex, int pageSize, long recommendedId);

}
