package com.myrecommended.daos.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.myrecommended.daos.RecommendedHiredDAO;
import com.myrecommended.models.Page;
import com.myrecommended.models.RecommendedHired;

@Repository
public class RecommendedHiredDAOImpl extends BaseDAOImpl<RecommendedHired, Long> implements RecommendedHiredDAO {

	protected RecommendedHiredDAOImpl() {
		super(RecommendedHired.class.getName());
	}
	
	public Page<RecommendedHired> getRecommendedHired(int pageIndex, int pageSize, long userId) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
		criteria.createAlias("user", "user");
		//TODO: ES NECESARIO LO DE ABAJO
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		criteria.add(Restrictions.eq("user.id", userId));

		return getPageByCriteria(criteria, pageIndex, pageSize);
	}

	public Page<RecommendedHired> getCustomers(int pageIndex, int pageSize, long recommendedId) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
		criteria.createAlias("recommended", "recommended");
		//TODO: ES NECESARIO LO DE ABAJO
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		criteria.add(Restrictions.eq("recommended.id", recommendedId));

		return getPageByCriteria(criteria, pageIndex, pageSize);
	}
}