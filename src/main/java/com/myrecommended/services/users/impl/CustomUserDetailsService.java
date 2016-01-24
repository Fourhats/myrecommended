package com.myrecommended.services.users.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.myrecommended.daos.UserDAO;
import com.myrecommended.models.User;
import com.myrecommended.security.CustomUser;
import com.myrecommended.security.UserGrantedAuthority;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		if (username != null && !username.equals("")) {
			User user = userDAO.getByUsername(username);
			if(user == null) {
				throw new UsernameNotFoundException("UserNameNotFound");
			}
			
			GrantedAuthority grantedAuth = new UserGrantedAuthority(user.getRole().getRole());
			return new CustomUser(user.getId(), user.getUsername(), user.getPassword(), user.isEnable(), new GrantedAuthority[]{ grantedAuth });
        } else {
        	throw new UsernameNotFoundException("UserNameNotFound");
        }
	}

}
