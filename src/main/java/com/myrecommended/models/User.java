package com.myrecommended.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends PersistibleEntity {
	
	public User() {
	}
	
	public User(String email, boolean enable, String username, String password, String name, String surname, String signInProvider, String providerId, String avatarName, Role role) {
		this.email = email;
		this.enable = enable;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.signInProvider = signInProvider;
		this.providerId = providerId;
		this.role = role;
		this.avatarName = avatarName;
		this.creationDate = new Date();
	}
	
	@Column(name="email",unique=true,nullable=false)
	private String email;
	
	@Column(name="enabled")
	private boolean enable;
	
	@Column(name="username",unique=true,nullable=false)
	private String username;

	@Column(name="password")
	private String password;
	
	@Column(name="name")
	public String name;
	
	@Column(name="surname")
	public String surname;
	
	@Column(name="sign_in_provider")
	public String signInProvider;
	
	@Column(name="providerId")
	public String providerId;
	
	@Column(name="creationDate")
	public Date creationDate;
	
	@Column(name="avatarName")
	private String avatarName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="user_roles",
		joinColumns = { @JoinColumn(name="user_Id", referencedColumnName="id") },
		inverseJoinColumns = { @JoinColumn(name="roles_Id", referencedColumnName="Id")}
	)
	private Role role;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getAvatarName() {
		return avatarName;
	}

	public void setAvatarName(String avatarName) {
		this.avatarName = avatarName;
	}
}