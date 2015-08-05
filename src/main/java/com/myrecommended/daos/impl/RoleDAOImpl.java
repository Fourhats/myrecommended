package com.myrecommended.daos.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.myrecommended.daos.RoleDAO;
import com.myrecommended.models.Role;

@Repository
public class RoleDAOImpl extends BaseDAOImpl<Role, Long> implements RoleDAO {

	protected RoleDAOImpl() {
		super(Role.class.getName());
	}

	public Role findByName(String roleName) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
        criteria.add(Restrictions.eq("role", roleName));
        return (Role) getHibernateTemplate().findByCriteria(criteria).get(0);
	}
}
