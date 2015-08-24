package com.myrecommended.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.myrecommended.services.recommended.RecommendedService;
import com.myrecommended.services.recommended.dtos.RecommendedDTO;
import com.myrecommended.services.users.UserService;
import com.myrecommended.services.users.dtos.UserDTO;

@Controller
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecommendedService recommendedService;
	
	
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
		UserDTO user =  this.userService.getUser(this.getUserId());
		model.addAttribute("user", gson.toJson(user));
		RecommendedDTO recommended = this.recommendedService.getRecommendedByUserId(user.getId());
		model.addAttribute("recommended", gson.toJson(recommended));
		
		return "user/profileRecommended";
    }
	
	//TODO: eliminar xq es singlepage
	@RequestMapping(value="/perfil/listadoTrabajos")
    public String jobList(Model model) {
		return "user/jobList";
    }
	
	//TODO: eliminar xq es singlepage
	@RequestMapping(value="/perfil/preguntas")
    public String questionsList(Model model) {
		return "user/questionsList";
    }
	
	@RequestMapping(value="/perfil/informacion")
    public String accountInformation(Model model) {
		return "user/accountInformation";
    }
}