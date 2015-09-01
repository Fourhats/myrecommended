package com.myrecommended.business.recommended.factories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myrecommended.models.RecommendedImage;
import com.myrecommended.services.recommended.dtos.RecommendedImageDTO;

@Component
public class RecommendedImageFactory {

	public RecommendedImage create(RecommendedImageDTO recommendedImageDto) {
		return new RecommendedImage(recommendedImageDto.getPath(), recommendedImageDto.isPrincipal());
	}

	public List<RecommendedImage> create(List<RecommendedImageDTO> recommendedImageDtos) {
		List<RecommendedImage> recommendedImages = new ArrayList<RecommendedImage>();
		for(RecommendedImageDTO image : recommendedImageDtos) {
			recommendedImages.add(this.create(image));
		}
		
		return recommendedImages;
	}
}