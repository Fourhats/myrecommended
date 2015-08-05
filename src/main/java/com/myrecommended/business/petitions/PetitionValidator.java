package com.myrecommended.business.petitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.business.petitions.exceptions.NotValidCategoryException;
import com.myrecommended.daos.CategoryDAO;
import com.myrecommended.services.petitions.dtos.PetitionRequestDTO;

@Component
public class PetitionValidator {

	@Autowired
	private CategoryDAO categoryDao;
	
	public void validate(PetitionRequestDTO petitionDto) throws MyRecommendedBusinessException {
		if(!this.categoryDao.existCategory(petitionDto.getCategoryId())) {
			throw new NotValidCategoryException("La categoria no existe");
		}
	}
}
