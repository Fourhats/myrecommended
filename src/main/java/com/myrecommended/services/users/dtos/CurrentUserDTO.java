package com.myrecommended.services.users.dtos;

import com.myrecommended.business.users.constants.SignInProvider;
import com.myrecommended.services.utils.MyRecommendedBaseDTO;

/**
 * 
 * @author dorozco
 * Used for current user. Sensitive data!
 */
public class CurrentUserDTO extends MyRecommendedBaseDTO {
	
	//TODO: SIRVE EL ID ACTUAL?
	private Long id;
	
	private String email;
	
	private String username;

	private String name;
	
	private String surname;
	
	private String avatarName;
	
	private String signInProvider;
	
	private String providerId;

	private boolean isFacebookLogin;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAvatarName() {
		return avatarName;
	}

	public void setAvatarName(String avatarName) {
		this.avatarName = avatarName;
	}

	public String getSignInProvider() {
		return signInProvider;
	}

	public void setSignInProvider(String signInProvider) {
		this.signInProvider = signInProvider;
		this.setIsFacebookLogin(this.signInProvider.equals(SignInProvider.FACEBOOK.getValue()));
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public boolean isFacebookLogin() {
		return isFacebookLogin;
	}

	public void setIsFacebookLogin(boolean isFacebookLogin) {
		this.isFacebookLogin = isFacebookLogin;
	}
}