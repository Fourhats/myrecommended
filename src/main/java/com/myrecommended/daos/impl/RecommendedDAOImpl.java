package com.myrecommended.daos.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
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
		
		criteria.addOrder(Order.asc("name"));
		
		return this.getPageByCriteria(criteria, pageIndex, pageSize);
	}

	public Page<Recommended> getRecommendedsPageByCategoryAndKeyword(int pageIndex, int pageSize, long categoryId, String recommendedKey) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.ilike("name", "%" + recommendedKey + "%"));
		
		if(categoryId != 0) {
			criteria.createAlias("categories", "categories");
			criteria.add(Restrictions.eq("categories.id", categoryId));
		}
		
		return getPageByCriteria(criteria, pageIndex, pageSize);
	}

	@SuppressWarnings("rawtypes")
	public Recommended getByUserId(Long userId) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
		criteria.createAlias("user", "user");
		criteria.add(Restrictions.eq("user.id", userId));
		List result = getHibernateTemplate().findByCriteria(criteria);
		if(!result.isEmpty()){
			return (Recommended) result.get(0);
		}
		
		return null;
	}
}