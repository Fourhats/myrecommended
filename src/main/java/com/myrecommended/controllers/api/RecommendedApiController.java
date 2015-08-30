package com.myrecommended.controllers.api;

import java.util.ArrayList;
import java.util.List;

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
	
	//TODO: ES NECESARIO EL MODELO ACA Y EN LOS DEMAS METODOS DE RECOMMENDEDAPICONTROLLER Y USERAPICONTROLLER???
	@RequestMapping(value = "/recommended/updateRecommended", method = RequestMethod.POST)
    public MyRecommendedBaseDTO updateRecommended(@RequestBody RecommendedRequestDTO recommendedDto, Model model) {
		MyRecommendedBaseDTO returnObject = new MyRecommendedBaseDTO();
		
		try {
			this.verifyAuthentication();
			
			recommendedDto.setUserId(this.getUserId());
			this.recommendedService.createOrUpdate(recommendedDto);
		} catch (AuthenticationCredentialsNotFoundException e) {
			returnObject.setError(e.getMessage());
			e.printStackTrace();
		} catch (MyRecommendedBusinessException e) {
			returnObject.setError(e.getMessage());
			e.printStackTrace();
		}
		
		return returnObject;
    }
	
	@RequestMapping(value="/recommended/{pageIndex}/{pageSize}", method = RequestMethod.GET, consumes="*/*")
	public @ResponseBody Page<RecommendedDTO> getRecommended(@PathVariable int pageIndex, @PathVariable int pageSize) {
		return this.recommendedService.getRecommendedsPage(pageIndex, pageSize, new ArrayList<Long>());	
	}
	
	@RequestMapping(value="/recommended/{pageIndex}/{pageSize}/{categories}", method = RequestMethod.GET, consumes="*/*")
	public @ResponseBody Page<RecommendedDTO> getFilteredRecommended(@PathVariable int pageIndex, @PathVariable int pageSize, @PathVariable List<Long> categories) {
		return this.recommendedService.getRecommendedsPage(pageIndex, pageSize, categories);	
	}
}