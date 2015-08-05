package com.myrecommended.daos.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.myrecommended.daos.RecommendedDAO;
import com.myrecommended.models.Page;
import com.myrecommended.models.Recommended;

@Repository
public class RecommendedDAOImpl extends BaseDAOImpl<Recommended, Long> implements RecommendedDAO {

	protected RecommendedDAOImpl() {
		super(Recommended.class.getName());
	}

	public boolean existByUserId(Long userId) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
		
		criteria.createCriteria("user", "user");
        criteria.add(Restrictions.eq("user.id", userId));
        
        return !getHibernateTemplate().findByCriteria(criteria).isEmpty();
	}
	
	public Page<Recommended> getRecommendedsPage(int pageIndex, int pageSize, List<Long> categoriesFiltered) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		if(!categoriesFiltered.isEmpty()) {
			criteria.createAlias("categories", "categories");
			criteria.add(Restrictions.in("categories.id", categoriesFiltered));
		}
		
		return getPageByCriteria(criteria, pageIndex, pageSize);
	}

	public Page<Recommended> getRecommendedsPageByKeyword(int pageIndex, int pageSize, String recommendedKey) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.createAlias("categories", "categories");
		criteria.createAlias("categories.categoryKeywords", "categoryKeywords");
		criteria.add(Restrictions.ilike("categoryKeywords.keyword", "%" + recommendedKey + "%"));
		
		return getPageByCriteria(criteria, pageIndex, pageSize);
	}
}