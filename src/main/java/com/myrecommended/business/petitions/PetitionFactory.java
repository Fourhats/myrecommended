package com.myrecommended.business.petitions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.daos.CategoryDAO;
import com.myrecommended.daos.UserDAO;
import com.myrecommended.models.Category;
import com.myrecommended.models.Petition;
import com.myrecommended.models.User;
import com.myrecommended.services.petitions.dtos.PetitionRequestDTO;

@Component
public class PetitionFactory {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private CategoryDAO categoryDao;
	
	public Petition create(PetitionRequestDTO petitionDto) {
		User user = this.userDao.getById(petitionDto.getUserId());
		Category category = this.categoryDao.getById(petitionDto.getCategoryId());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
	    Date initialDate = new Date();
		try {
			initialDate = dateFormat.parse(petitionDto.getInitialDate());
		} catch (ParseException e) {
			e.printStackTrace();
		} 
	    
		return new Petition(user, category, petitionDto.getTitle(), petitionDto.getDescription(), initialDate, petitionDto.getAddress());
	}
}
