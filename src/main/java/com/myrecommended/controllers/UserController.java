package com.myrecommended.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.myrecommended.services.categories.CategoryService;
import com.myrecommended.services.categories.dtos.CategoryDTO;
import com.myrecommended.services.recommended.RecommendedService;
import com.myrecommended.services.recommended.dtos.RecommendedDTO;
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
		
		model.addAttribute("user", gson.toJson(user));
		model.addAttribute("recommended", gson.toJson(recommended));
		model.addAttribute("categories", gson.toJson(categories));
		
		return "user/profileRecommended";
    }
}