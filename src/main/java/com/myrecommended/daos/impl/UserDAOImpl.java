package com.myrecommended.daos.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.myrecommended.daos.UserDAO;
import com.myrecommended.models.User;

@Repository
public class UserDAOImpl extends BaseDAOImpl<User, Long> implements UserDAO {

	protected UserDAOImpl() {
		super(User.class.getName());
	}

	@SuppressWarnings("rawtypes")
	public User getByUsername(String username) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
		criteria.add(Restrictions.eq("username", username));
		List result = getHibernateTemplate().findByCriteria(criteria);
		if(!result.isEmpty()){
			return (User) result.get(0);
		}
		
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public User getByEmail(String email) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
		criteria.add(Restrictions.eq("email", email));
		List result = getHibernateTemplate().findByCriteria(criteria);
		if(!result.isEmpty()){
			return (User) result.get(0);
		}
		
		return null;
	}
	
	public boolean existUser(Long userId) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
        criteria.add(Restrictions.eq("id", userId));
        return !getHibernateTemplate().findByCriteria(criteria).isEmpty();
	}
	
	public boolean existUser(String email) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
		criteria.add(Restrictions.eq("email", email));
		return !getHibernateTemplate().findByCriteria(criteria).isEmpty();
	}
}