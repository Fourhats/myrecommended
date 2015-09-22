package com.myrecommended.daos;

import java.util.List;

import com.myrecommended.models.Page;
import com.myrecommended.models.Recommended;

public interface RecommendedDAO extends BaseDAO<Recommended, Long> {

	boolean existByUserId(Long userId);
	
	Page<Recommended> getRecommendedsPage(int pageIndex, int pageSize, List<Long> categoriesFiltered);

	Page<Recommended> getRecommendedsPageByCategoryAndKeyword(int pageIndex, int pageSize, long categoryId, String recommendedKey);

	Recommended getByUserId(Long userId);
}