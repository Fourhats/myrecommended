package com.myrecommended.daos.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.myrecommended.daos.QuestionableObjectDAO;
import com.myrecommended.models.QuestionableObject;

@Repository
public class QuestionableObjectDAOImpl extends BaseDAOImpl<QuestionableObject, Long> implements QuestionableObjectDAO {

	protected QuestionableObjectDAOImpl() {
		super(QuestionableObject.class.getName());
	}

	@SuppressWarnings("rawtypes")
	public QuestionableObject getByEntity(long entityId, int entityType) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
		
        criteria.add(Restrictions.eq("entityId", entityId));
        criteria.add(Restrictions.eq("entityType", entityType));

        List result = getHibernateTemplate().findByCriteria(criteria);
		if(!result.isEmpty()){
			return (QuestionableObject) result.get(0);
		}
		
		return null;
	}
}
