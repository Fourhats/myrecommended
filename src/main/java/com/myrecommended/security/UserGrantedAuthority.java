package com.myrecommended.security;

import org.springframework.security.core.GrantedAuthority;

public class UserGrantedAuthority implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4107198527912833969L;

	private String authority = null;
	
	public UserGrantedAuthority(String auth){
		this.authority = auth;
	}
	
	public String getAuthority() {
		return authority;
	}

}