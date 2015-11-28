package com.myrecommended.daos;

import com.myrecommended.models.QuestionableObject;

public interface QuestionableObjectDAO extends BaseDAO<QuestionableObject, Long> {

	public QuestionableObject getByEntity(long entityId, int entityType);
}