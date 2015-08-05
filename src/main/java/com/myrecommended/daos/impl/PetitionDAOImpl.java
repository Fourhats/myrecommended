package com.myrecommended.daos.impl;

import org.springframework.stereotype.Repository;

import com.myrecommended.daos.PetitionDAO;
import com.myrecommended.models.Petition;

@Repository
public class PetitionDAOImpl extends BaseDAOImpl<Petition, Long> implements PetitionDAO {

	protected PetitionDAOImpl() {
		super(Petition.class.getName());
	}
}