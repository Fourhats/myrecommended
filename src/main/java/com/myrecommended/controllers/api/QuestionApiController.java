package com.myrecommended.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myrecommended.business.MyRecommendedBusinessException;
import com.myrecommended.constants.ObjectTypes;
import com.myrecommended.controllers.BaseController;
import com.myrecommended.models.Page;
import com.myrecommended.services.questions.QuestionService;
import com.myrecommended.services.questions.dtos.AnswerRequestDTO;
import com.myrecommended.services.questions.dtos.QuestionDTO;
import com.myrecommended.services.questions.dtos.QuestionRequestDTO;
import com.myrecommended.services.utils.MyRecommendedBaseDTO;

@RestController
public class QuestionApiController extends BaseController {

	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "/questions/makeQuestion", method = RequestMethod.POST)
    public @ResponseBody QuestionDTO makeQuestionToRecommended(@RequestBody QuestionRequestDTO questionDto) {
		QuestionDTO returnObject = new QuestionDTO();
		
		try {
			this.verifyAuthentication();
			
			questionDto.setEntityType(ObjectTypes.RECOMMENDED.getValue());
			questionDto.setUserId(this.getUserId());
			returnObject = this.questionService.addQuestion(questionDto);
		} catch (MyRecommendedBusinessException e) {
			returnObject.setError(e.getMessage());
			e.printStackTrace();
		} catch (AuthenticationCredentialsNotFoundException e) {
			returnObject.setError("Debe ingresar a Mis Recomendados para poder hacer preguntas");
			e.printStackTrace();
		}
		
		return returnObject;
	}
	
	@RequestMapping(value = "/questions/answerQuestion", method = RequestMethod.POST)
    public @ResponseBody MyRecommendedBaseDTO answerQuestion(@RequestBody AnswerRequestDTO answerDto) {
		MyRecommendedBaseDTO returnObject = new MyRecommendedBaseDTO();
		
		try {
			this.verifyAuthentication();
			
			answerDto.setUserId(this.getUserId());
			this.questionService.answerQuestion(answerDto);
		} catch (MyRecommendedBusinessException e) {
			returnObject.setError(e.getMessage());
			e.printStackTrace();
		} catch (AuthenticationCredentialsNotFoundException e) {
			returnObject.setError("Debe ingresar a Mis Recomendados para poder hacer preguntas");
			e.printStackTrace();
		}
		
		return returnObject;
	}
	
	@RequestMapping(value="/questions/{entityId}/{pageIndex}/{pageSize}", method = RequestMethod.GET, consumes="*/*")
	public @ResponseBody Page<QuestionDTO> getQuestions(@PathVariable long entityId, @PathVariable int pageIndex, @PathVariable int pageSize) {
		return this.questionService.getQuestions(entityId, pageIndex, pageSize);	
	}
}