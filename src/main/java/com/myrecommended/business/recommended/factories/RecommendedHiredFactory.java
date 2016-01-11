package com.myrecommended.business.recommended.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.daos.RecommendedDAO;
import com.myrecommended.daos.UserDAO;
import com.myrecommended.models.Recommended;
import com.myrecommended.models.RecommendedHired;
import com.myrecommended.models.User;
import com.myrecommended.services.recommended.dtos.HireRecommendedRequestDTO;

@Component
public class RecommendedHiredFactory {

	@Autowired
	private RecommendedDAO recommendedDao;
	
	@Autowired
	private UserDAO userDao;
	
	public RecommendedHired create(HireRecommendedRequestDTO hireRecommendedDto) {
		//TODO: VALIDAR RECOMENDADO Y USUARIO VALIDO
		Recommended recommended = this.recommendedDao.getById(hireRecommendedDto.getRecommendedId());
		User user = this.userDao.getById(hireRecommendedDto.getUserId());
		
		return new RecommendedHired(recommended, user);
	}
}
