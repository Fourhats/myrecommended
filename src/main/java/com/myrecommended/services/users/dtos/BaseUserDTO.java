package com.myrecommended.services.users.dtos;

import com.myrecommended.constants.SignInProvider;

public class BaseUserDTO {

	private Long id;
	
	private String email;
	
	private String name;
	
	private String surname;
	
	private String fullName;
	
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
		this.setFullName(this.name + " " + this.surname);
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
		this.setIsFacebookLogin(this.signInProvider.equals(SignInProvider.FACEBOOK.getValue()));
	}

	public boolean isFacebookLogin() {
		return isFacebookLogin;
	}

	public void setIsFacebookLogin(boolean isFacebookLogin) {
		this.isFacebookLogin = isFacebookLogin;
	}
}