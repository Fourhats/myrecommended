package com.myrecommended.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.myrecommended.services.categories.CategoryService;

@Controller
public class HomeController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/")
    public String index(Model model) {
		return this.home(model);
    }
	
	@RequestMapping(value="/home")
    public String home(Model model) {
		Gson gson = new Gson();
		model.addAttribute("categories", gson.toJson(this.categoryService.getAllCategories()));
		
		return "home";
    }
	
	@RequestMapping(value="/tusServicios")
    public String giveYourServices(Model model) {
		return "/info/giveYourServices";
    }
	
	@RequestMapping(value="/comoFunciona")
    public String howWorks(Model model) {
		return "/info/howWorks";
    }
}