package com.myrecommended.daos;

import com.myrecommended.models.Role;

public interface RoleDAO extends BaseDAO<Role, Long> {
	
	public Role findByName(String roleName);
}
