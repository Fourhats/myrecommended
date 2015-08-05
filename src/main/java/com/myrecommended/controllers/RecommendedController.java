package com.myrecommended.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.myrecommended.services.categories.CategoryService;
import com.myrecommended.services.recommended.RecommendedService;

@Controller
public class RecommendedController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private RecommendedService recommendedService;
	
	@RequestMapping(value="/pedilo")
    public String request(Model model) {
		Gson gson = new Gson();
		model.addAttribute("categories", gson.toJson(this.categoryService.getAllCategories()));
		return "recommended/petition";
    }
	
	@RequestMapping(value="/recomendados")
    public String recommended(Model model) {
		Gson gson = new Gson();
		
		model.addAttribute("categories", gson.toJson(this.categoryService.getAllCategories()));
		model.addAttribute("recommendedPage", gson.toJson(this.recommendedService.getRecommendedsPage(1, 3, new ArrayList<Long>())));
		return "recommended/recommendedGallery";
    }
	
	@RequestMapping(value="/recomendados/{recommendedKey}")
    public String recommended(@PathVariable String recommendedKey, Model model) {
		Gson gson = new Gson();
		
		model.addAttribute("categories", gson.toJson(this.categoryService.getAllCategories()));
		model.addAttribute("recommendedPage", gson.toJson(this.recommendedService.getRecommendedsPageByKeyword(1, 3, recommendedKey)));
		return "recommended/recommendedGallery";
    }
	
	@RequestMapping(value="/recomendado")
    public String singleRecommended(Model model) {
		return "singleRecommended";
    }
}
