package com.myrecommended.daos.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.myrecommended.daos.AnswerDAO;
import com.myrecommended.models.Answer;

@Repository
public class AnswerDAOImpl extends BaseDAOImpl<Answer, Long> implements AnswerDAO {

	protected AnswerDAOImpl() {
		super(Answer.class.getName());
	}

	//TODO: VER SI SE NECESITA
	@SuppressWarnings("unchecked")
	public List<Answer> getAnswersByQuestionId(long questionId) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
		
		criteria.createCriteria("question", "question");
        criteria.add(Restrictions.eq("question.id", questionId));
        criteria.addOrder(Order.desc("date"));
        
        return (List<Answer>) getHibernateTemplate().findByCriteria(criteria);
	}

	//TODO: VER SI SE NECESITA
	public boolean hasAnswers(long questionId) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
		
		criteria.createCriteria("question", "question");
        criteria.add(Restrictions.eq("question.id", questionId));
        
        return !getHibernateTemplate().findByCriteria(criteria).isEmpty();
	}

	//TODO: VER SI SE NECESITA
	public boolean hasAnswersSince(Long questionId, Date date) {
		DetachedCriteria criteria = DetachedCriteria.forEntityName(entityName);
		
		criteria.createCriteria("question", "question");
        criteria.add(Restrictions.eq("question.id", questionId));
        criteria.add(Restrictions.gt("date", date));
        
        return !getHibernateTemplate().findByCriteria(criteria).isEmpty();
	}
}