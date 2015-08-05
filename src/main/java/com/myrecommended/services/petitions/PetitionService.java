package com.myrecommended.services.petitions;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.services.petitions.dtos.PetitionDTO;
import com.myrecommended.services.petitions.dtos.PetitionRequestDTO;

@Service
public interface PetitionService {

	@Transactional
	PetitionDTO addPetition(PetitionRequestDTO petitionDto) throws MyRecommendedBusinessException;

}