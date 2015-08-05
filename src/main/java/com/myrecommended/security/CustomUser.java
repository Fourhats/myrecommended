package com.myrecommended.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUser implements Serializable, UserDetails{

	private static final long serialVersionUID = 6681234251137055177L;
	private long id;
    private String password;
    private String username;
    private boolean enabled;
    private String fullName;
    private GrantedAuthority[] authorities = null;

    public CustomUser(long id, String username, String password, boolean enabled/*, String firstName, String lastName*/, GrantedAuthority[] authorities){
    	//StringBuilder builder = new StringBuilder(firstName);
    	//builder.append(" " + lastName);
    	this.setId(id);
    	this.password = password;
    	this.username = username;
    	this.enabled = enabled;
    	//this.setFullName(builder.toString());
    	this.setFullName(username);
    	this.authorities = authorities;
    }
    
	public Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		Collections.addAll(auth, authorities);
		return auth;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}