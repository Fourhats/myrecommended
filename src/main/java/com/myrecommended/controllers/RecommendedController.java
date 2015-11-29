package com.myrecommended.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.myrecommended.services.categories.CategoryService;
import com.myrecommended.services.questions.QuestionService;
import com.myrecommended.services.recommended.RecommendedService;

@Controller
public class RecommendedController extends BaseController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private RecommendedService recommendedService;
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value="/pedilo")
    public String goToPedilo(Model model) {
		Gson gson = new Gson();
		model.addAttribute("categories", gson.toJson(this.categoryService.getAllCategories()));
		
		return "recommended/petition";
    }
	
	@RequestMapping(value="/recomendados")
    public String goToRecomendados(Model model) {
		return this.goToGallery(0, "", model);
    }
	
	@RequestMapping(value="/recomendado/{recommendedId}/{recommendedName}")
    public String goToRecomendadosDetail(@PathVariable long recommendedId, @PathVariable String recommendedName, Model model) {
		Gson gson = new Gson();
		
		model.addAttribute("recommended", gson.toJson(this.recommendedService.getRecommendedById(recommendedId, this.getUserId())));
		model.addAttribute("recommendedQuestions", gson.toJson(this.questionService.getQuestions(recommendedId, 0, 5)));
		
		return "recommended/recommendedDetail";
    }
	
	@RequestMapping(value="/recomendados/{categoryId}/{recommendedKey}")
    public String goToRecomendadosGalleryFiltered(@PathVariable long categoryId, @PathVariable String recommendedKey, Model model) {
		return this.goToGallery(categoryId, recommendedKey, model);
    }
	
	@RequestMapping(value="/recomendados/{categoryId}")
    public String goToRecomendadosGallery(@PathVariable long categoryId, Model model) {
		return this.goToGallery(categoryId, "", model);
    }
	
	private String goToGallery(long categoryId, String recommendedKey, Model model) {
		Gson gson = new Gson();
		
		model.addAttribute("categories", gson.toJson(this.categoryService.getAllCategories()));
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("recommendedPage", gson.toJson(this.recommendedService.getRecommendedsPageByCategoryAndKeyword(1, 3, categoryId, recommendedKey)));
		model.addAttribute("recommendedKey", gson.toJson(recommendedKey));
		
		return "recommended/recommendedGallery";
	}
}