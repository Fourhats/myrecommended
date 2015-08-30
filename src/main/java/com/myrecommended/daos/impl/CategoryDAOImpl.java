package com.myrecommended.daos.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.myrecommended.daos.CategoryDAO;
import com.myrecommended.models.Category;

@Repository
public class CategoryDAOImpl extends BaseDAOImpl<Category, Long> implements CategoryDAO {

	protected CategoryDAOImpl() {
		super(Category.class.getName());
	}

	@SuppressWarnings("unchecked")
	public List<Category> getByIds(List<Long> categoryIds) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
		criteria.add(Restrictions.in("id", categoryIds));
		criteria.addOrder(Order.asc("name"));
		return (List<Category>) getHibernateTemplate().findByCriteria(criteria);
	}

	public boolean existCategory(Long categoryId) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
		criteria.add(Restrictions.eq("id", categoryId));
		return !getHibernateTemplate().findByCriteria(criteria).isEmpty();
	}
}
