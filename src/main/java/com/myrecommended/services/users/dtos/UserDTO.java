package com.myrecommended.services.users.dtos;

public class UserDTO {
	
	private Long id;
	
	private String email;
	
	private String username;

	public String name;
	
	public String surname;
	
	public String error;

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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}