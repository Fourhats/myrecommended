package com.myrecommended.business.users;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.daos.RoleDAO;
import com.myrecommended.models.Role;
import com.myrecommended.models.User;
import com.myrecommended.services.users.dtos.UserRequestDTO;

@Component
public class UserFactory {

	@Autowired
	private RoleDAO roleDao;
	
	public User Create(UserRequestDTO userDto) {
		Role role = this.roleDao.findByName("ROLE_USER");
		
		return new User(userDto.getEmail(), true, userDto.getUsername(), 
				userDto.getPassword(), userDto.getName(), userDto.getSurname(), 
				userDto.getSignInProvider(), userDto.getProviderId(), userDto.getAvatarPath(), role);
	}

	public User Create(com.restfb.types.User fbUser) {
		Role role = this.roleDao.findByName("ROLE_USER");
		String password = UUID.randomUUID().toString();
		
		return new User(fbUser.getEmail(), true, fbUser.getEmail(), 
				password, fbUser.getFirstName(), fbUser.getLastName(), 
				"FACEBOOK", fbUser.getId(), "", role);//TODO: VER FACEBOOK image PATH
	}
}
