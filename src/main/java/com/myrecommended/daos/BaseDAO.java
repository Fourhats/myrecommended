package com.myrecommended.daos;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO <T, PK extends Serializable> {

	public void add(T t);
	
	public void delete(T t);
	
	public T getById(PK id);
	
	public List<T> getAll();
}