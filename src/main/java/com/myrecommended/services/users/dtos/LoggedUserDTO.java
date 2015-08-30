package com.myrecommended.services.users.dtos;

import com.myrecommended.services.utils.MyRecommendedBaseDTO;

/**
 * @author dorozco
 *
 * Used after user registration to log in the user
 */
public class LoggedUserDTO extends MyRecommendedBaseDTO {

	private String email;
	
	private String username;
	
	//TODO: ver si sirve para algo!
	private String password;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}