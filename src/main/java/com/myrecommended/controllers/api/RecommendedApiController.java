package com.myrecommended.controllers.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.controllers.BaseController;
import com.myrecommended.models.Page;
import com.myrecommended.services.recommended.RecommendedService;
import com.myrecommended.services.recommended.dtos.RecommendedDTO;
import com.myrecommended.services.recommended.dtos.RecommendedRequestDTO;
import com.myrecommended.services.utils.MyRecommendedBaseDTO;

@RestController
public class RecommendedApiController extends BaseController {

	@Autowired
	private RecommendedService recommendedService;
	
	@RequestMapping(value = "/recommended/updateRecommended", method = RequestMethod.POST)
    public MyRecommendedBaseDTO updateRecommended(@RequestBody RecommendedRequestDTO recommendedDto, Model model) throws FileNotFoundException, IOException, Exception {
		MyRecommendedBaseDTO returnObject = new MyRecommendedBaseDTO();
		
		try {
			this.verifyAuthentication();
			
			recommendedDto.setUserId(this.getUserId());
			this.recommendedService.createOrUpdate(recommendedDto);
		} catch (MyRecommendedBusinessException e) {
			returnObject.setError(e.getMessage());
			e.printStackTrace();
		} catch (AuthenticationCredentialsNotFoundException e) {
			returnObject.setError(e.getMessage());
			e.printStackTrace();
		}
		
		return returnObject;
    }
	
	@RequestMapping(value="/recommended/{pageIndex}/{pageSize}", method = RequestMethod.GET, consumes="*/*")
	public @ResponseBody Page<RecommendedDTO> getRecommended(@PathVariable int pageIndex, @PathVariable int pageSize) {
		return this.recommendedService.getRecommendedsPage(pageIndex, pageSize, new ArrayList<Long>());	
	}
	
	@RequestMapping(value="/recommended/{pageIndex}/{pageSize}/{categoryId}", method = RequestMethod.GET, consumes="*/*")
	public @ResponseBody Page<RecommendedDTO> getRecommendedFilteredByCategory(@PathVariable int pageIndex, @PathVariable int pageSize, @PathVariable long categoryId) {
		return this.recommendedService.getRecommendedsPageByCategoryAndKeyword(pageIndex, pageSize, categoryId, "");	
	}
	
	@RequestMapping(value="/recommended/{pageIndex}/{pageSize}/{categoryId}/{keyword}", method = RequestMethod.GET, consumes="*/*")
	public @ResponseBody Page<RecommendedDTO> getRecommendedFilteredByCategoryAndKeyword(@PathVariable int pageIndex, @PathVariable int pageSize, @PathVariable long categoryId, @PathVariable String keyword) {
		return this.recommendedService.getRecommendedsPageByCategoryAndKeyword(pageIndex, pageSize, categoryId, keyword);	
	}
}