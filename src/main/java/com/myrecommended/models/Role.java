package com.myrecommended.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

	@Id
	@GeneratedValue
	private Long Id;
	
	private String role;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="user_roles",
		joinColumns = { @JoinColumn(name="roles_Id", referencedColumnName="Id") },
		inverseJoinColumns = { @JoinColumn(name="user_Id", referencedColumnName="id")}
	)
	
	private Set<User> userRoles;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<User> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<User> userRoles) {
		this.userRoles = userRoles;
	}
}