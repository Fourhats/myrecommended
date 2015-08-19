package com.myrecommended.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController extends BaseController {
	
	@RequestMapping(value="/registracion")
    public String goToRegister(Model model) {
		if(this.isUserLogged()) {
			return "redirect:/home";
		}
		
		return "user/register";
    }
	
	//Borrar cuando funcione
	@RequestMapping(value="/miperfil")
    public String myprofile(Model model) {
		
		return "user/profileRecommended";
    }
	
	@RequestMapping(value="/miperfildetalles")
    public String myprofileMore(Model model) {
		
		return "user/profileRecommendedMore";
    }
	
	
	//Fin Borrar
	@RequestMapping(value="/perfil")
    public String profileRecommended(Model model) {
		if(!this.isUserLogged()) {
			return "redirect:/home";
		}
		
		return "user/profileRecommended";
    }
	
	@RequestMapping(value="/perfil/listadoTrabajos")
    public String jobList(Model model) {
		return "user/jobList";
    }
	
	@RequestMapping(value="/perfil/preguntas")
    public String questionsList(Model model) {
		return "user/questionsList";
    }
	
	@RequestMapping(value="/perfil/informacion")
    public String accountInformation(Model model) {
		return "user/accountInformation";
    }
}