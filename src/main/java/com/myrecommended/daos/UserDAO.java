package com.myrecommended.daos;

import com.myrecommended.models.User;

public interface UserDAO extends BaseDAO<User, Long> {

	User getByUsername(String username);
	
	User getByEmail(String email);
	
	boolean existUser(Long userId);
	
	boolean existUser(String email);
}