package com.myrecommended.business.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.daos.QuestionDAO;
import com.myrecommended.models.Page;
import com.myrecommended.models.Question;

@Component
public class QuestionSearcher {

	@Autowired
	private QuestionDAO questionDao;
	
	public Page<Question> getPage(int pageIndex, int pageSize, Long entityId) {
		return this.questionDao.getQuestions(pageIndex, pageSize, entityId);
	}
}
