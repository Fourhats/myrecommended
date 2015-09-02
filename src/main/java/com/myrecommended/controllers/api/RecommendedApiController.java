package com.myrecommended.controllers.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.myrecommended.services.utils.FileHelper;
import com.myrecommended.services.utils.MyRecommendedBaseDTO;

@RestController
public class RecommendedApiController extends BaseController {

	@Autowired
	private RecommendedService recommendedService;
	
	@Value("#{configProps}")
	private Properties properties;
	
	private final String RECOMMENDED_OLD_JOBS_FOLDER = "recommendedOldJobs";
	
	@RequestMapping(value = "/recommended/updateRecommended", method = RequestMethod.POST)
    public MyRecommendedBaseDTO updateRecommended(@RequestBody RecommendedRequestDTO recommendedDto, Model model) throws FileNotFoundException, IOException, Exception {
		String tempPath = properties.getProperty("folder.temp");
		String recommendedOldJobsPath = properties.getProperty("folder.recommendedOldJobs");
		
		MyRecommendedBaseDTO returnObject = new MyRecommendedBaseDTO();
		
		try {
			this.verifyAuthentication();
			
			recommendedDto.setUserId(this.getUserId());
			this.recommendedService.createOrUpdate(recommendedDto);
			
			FileHelper.generateImagesWithDifferentSizes(recommendedDto.getRecommendedImageNames(), tempPath, RECOMMENDED_OLD_JOBS_FOLDER, recommendedOldJobsPath);
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