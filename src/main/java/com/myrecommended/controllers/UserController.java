package com.myrecommended.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.myrecommended.models.Page;
import com.myrecommended.services.categories.CategoryService;
import com.myrecommended.services.categories.dtos.CategoryDTO;
import com.myrecommended.services.questions.QuestionService;
import com.myrecommended.services.questions.dtos.QuestionDTO;
import com.myrecommended.services.recommended.RecommendedService;
import com.myrecommended.services.recommended.dtos.RecommendedDTO;
import com.myrecommended.services.recommended.dtos.RecommendedHiredDTO;
import com.myrecommended.services.users.UserService;
import com.myrecommended.services.users.dtos.CurrentUserDTO;

@Controller
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecommendedService recommendedService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value="/registracion")
    public String goToRegister(Model model) {
		if(this.isUserLogged()) {
			return "redirect:/home";
		}
		
		return "user/register";
    }
	
	@RequestMapping(value="/perfil")
    public String goToRecommendedProfile(Model model) {
		if(!this.isUserLogged()) {
			return "redirect:/home";
		}
		
		Gson gson = new Gson();
		CurrentUserDTO user =  this.userService.getUser(this.getUserId());
		RecommendedDTO recommended = this.recommendedService.getRecommendedByUserId(user.getId());
		List<CategoryDTO> categories = this.categoryService.getAllCategories();
		//TODO: Dani, arregla esto
		Page<QuestionDTO> questions = new Page<QuestionDTO>(new ArrayList<QuestionDTO>(),0,0,new Long(0));
		Page<RecommendedHiredDTO> customersPage = new Page<RecommendedHiredDTO>(new ArrayList<RecommendedHiredDTO>(),0,0,new Long(0));
		if (recommended != null){
			questions = this.questionService.getQuestions(recommended.getId(), 0, 100);
			customersPage = this.recommendedService.getCustomers(recommended.getId());
		}
		Page<RecommendedHiredDTO> recommendedsHiredPage = this.recommendedService.getRecommendedHired(user.getId());
		
		model.addAttribute("user", gson.toJson(user));
		model.addAttribute("recommended", gson.toJson(recommended));
		model.addAttribute("categories", gson.toJson(categories));
		model.addAttribute("questionsPage", gson.toJson(questions));
		model.addAttribute("recommendedsHiredPage", gson.toJson(recommendedsHiredPage));
		model.addAttribute("customersPage", gson.toJson(customersPage));
		
		return "user/profileRecommended";
    }
}