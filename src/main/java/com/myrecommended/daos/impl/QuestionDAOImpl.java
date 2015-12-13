package com.myrecommended.daos.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.myrecommended.daos.QuestionDAO;
import com.myrecommended.models.Page;
import com.myrecommended.models.Question;

@Repository
public class QuestionDAOImpl extends BaseDAOImpl<Question, Long> implements QuestionDAO {

	protected QuestionDAOImpl() {
		super(Question.class.getName());
	}

	public Page<Question> getQuestions(int pageIndex, int pageSize, long entityId) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);

		criteria.createCriteria("questionableObject", "questionableObject");
        criteria.add(Restrictions.eq("questionableObject.entityId", entityId));
        
        criteria.addOrder(Order.desc("date"));
        
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        
        return this.getPageByCriteria(criteria, pageIndex, pageSize);
	}
	
	//TODO: VER SI SE NECESITA
	@SuppressWarnings("unchecked")
	public List<Question> getQuestionByUser(long userId) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
        
		criteria.createCriteria("user", "user");
		
		criteria.add(Restrictions.eq("user.id", userId));
        criteria.addOrder(Order.desc("date"));
        
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Question>) getHibernateTemplate().findByCriteria(criteria);
	}
}