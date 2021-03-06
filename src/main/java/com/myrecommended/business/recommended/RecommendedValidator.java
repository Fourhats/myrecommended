package com.myrecommended.business.recommended;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.business.categories.exceptions.CategoryNotExistException;
import com.myrecommended.business.recommended.exceptions.RecommendedAlreadyExistException;
import com.myrecommended.business.recommended.exceptions.RecommendedCategorieslessException;
import com.myrecommended.business.recommended.exceptions.RecommendedImagesLengthException;
import com.myrecommended.business.recommended.exceptions.RecommendedNotExistException;
import com.myrecommended.daos.CategoryDAO;
import com.myrecommended.daos.RecommendedDAO;
import com.myrecommended.services.recommended.dtos.RecommendedRequestDTO;

@Component
public class RecommendedValidator {

	@Autowired
	private RecommendedDAO recommendedDao;
	
	@Autowired
	private CategoryDAO categoryDao;
	
	public void validateIfCanCreate(RecommendedRequestDTO recommendedDto) throws MyRecommendedBusinessException {
		this.validateIfRecommendedNotExists(recommendedDto.getUserId());
		this.validateValidCategories(recommendedDto.getCategoryIds());
		this.validateQuantityImages(recommendedDto.getRecommendedImages().size());
	}

	public void validateIfCanUpdate(RecommendedRequestDTO recommendedDto) throws MyRecommendedBusinessException {
		this.validateIfRecommendedExist(recommendedDto.getUserId());
		this.validateValidCategories(recommendedDto.getCategoryIds());
		this.validateQuantityImages(recommendedDto.getRecommendedImages().size());
	}

	//RECOMMENDED VALIDATIONS
	private void validateIfRecommendedExist(Long userId) throws RecommendedNotExistException {
		if(!this.recommendedDao.existByUserId(userId)) {
			throw new RecommendedNotExistException("El recomendado que quiere actualizar no existe");
		}
	}
	
	private void validateIfRecommendedNotExists(Long userId) throws RecommendedAlreadyExistException {
		if(this.recommendedDao.existByUserId(userId)) {
			throw new RecommendedAlreadyExistException("Ya existe este recomendado");
		}
	}
	
	//CATEGORIES VALIDATIONS
	private void validateValidCategories(List<Long> categoryIds) throws MyRecommendedBusinessException {
		this.validateIfHasCategories(categoryIds);
		this.validateIfCategoriesExist(categoryIds);
	}
	
	private void validateIfCategoriesExist(List<Long> categoryIds) throws CategoryNotExistException {
		for(long categoryId : categoryIds) {
			if(!this.categoryDao.existCategory(categoryId)) {
				throw new CategoryNotExistException("No existe una de las categor�as");
			}
		}
	}
	
	private void validateIfHasCategories(List<Long> categoryIds) throws RecommendedCategorieslessException {
		if(categoryIds == null || categoryIds.isEmpty()) {
			throw new RecommendedCategorieslessException("El recomendado no tiene categorias");
		}
	}
	
	//IMAGES VALIDATIONS
	private void validateQuantityImages(int imagesQuantity) throws RecommendedImagesLengthException {
		if(imagesQuantity > 5) {
			throw new RecommendedImagesLengthException("El m�ximo de imagenes es 5");
		}
	}
}
