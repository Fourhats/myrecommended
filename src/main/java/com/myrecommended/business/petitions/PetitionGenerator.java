package com.myrecommended.business.petitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.daos.PetitionDAO;
import com.myrecommended.models.Petition;
import com.myrecommended.services.petitions.dtos.PetitionRequestDTO;

@Component
public class PetitionGenerator {

	@Autowired
	private PetitionFactory petitionFactory;
	
	@Autowired
	private PetitionValidator petitionValidator;
	
	@Autowired 
	private PetitionDAO petitionDao;
	
	public Petition generate(PetitionRequestDTO petitionDto) throws MyRecommendedBusinessException {
		this.petitionValidator.validate(petitionDto);
		Petition petition = this.petitionFactory.create(petitionDto);
		this.petitionDao.add(petition);
		return petition; 
	}
}
