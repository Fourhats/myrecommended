package com.myrecommended.services.categories.dtos;

import java.util.List;

import com.myrecommended.services.recommended.dtos.RecommendedDTO;

public class FullCategoryDTO extends CategoryDTO {

	private List<RecommendedDTO> recommended;

	public List<RecommendedDTO> getRecommended() {
		return recommended;
	}

	public void setRecommended(List<RecommendedDTO> recommended) {
		this.recommended = recommended;
	}
}