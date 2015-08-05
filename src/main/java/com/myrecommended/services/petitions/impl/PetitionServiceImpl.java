package com.myrecommended.services.petitions.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.business.petitions.PetitionGenerator;
import com.myrecommended.models.Petition;
import com.myrecommended.services.petitions.PetitionService;
import com.myrecommended.services.petitions.dtos.PetitionDTO;
import com.myrecommended.services.petitions.dtos.PetitionRequestDTO;
import com.myrecommended.services.utils.MapperUtil;

public class PetitionServiceImpl implements PetitionService {

	@Autowired
	private Mapper mapper;
	
	@Autowired
	private PetitionGenerator petitionGenerator;
	
	public PetitionDTO addPetition(PetitionRequestDTO petitionDto) throws MyRecommendedBusinessException {
		Petition petition = this.petitionGenerator.generate(petitionDto);
		return MapperUtil.map(mapper, petition, PetitionDTO.class);
	}
}