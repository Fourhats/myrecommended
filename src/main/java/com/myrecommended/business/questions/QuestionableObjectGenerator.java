package com.myrecommended.business.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.daos.QuestionableObjectDAO;
import com.myrecommended.models.QuestionableObject;

@Component
public class QuestionableObjectGenerator {

	@Autowired
	private QuestionableObjectDAO questionableObjectDAO;
	
	public QuestionableObject generate(long entityId, int entityType) {
		QuestionableObject qo = this.questionableObjectDAO.getByEntity(entityId, entityType);
		if(qo == null) {
			qo = new QuestionableObject(entityId, entityType);
			this.questionableObjectDAO.add(qo);
		}
		
		return qo;
	}
}