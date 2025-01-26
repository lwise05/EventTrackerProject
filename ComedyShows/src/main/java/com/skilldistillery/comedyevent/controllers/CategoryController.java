package com.skilldistillery.comedyevent.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.comedyevent.entities.Category;
import com.skilldistillery.comedyevent.entities.ComedyEvent;
import com.skilldistillery.comedyevent.services.CategoryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class CategoryController {

		
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping({"categories", "categories/"})
	public List<Category> index(){
		return categoryService.findAll();
	}
	
	@GetMapping("categories/{categoryId}")
	public Category findById(@PathVariable("categoryId") int categoryId, HttpServletResponse res) {
		
		Category category = categoryService.findById(categoryId);
		
		if(category == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
		}
		res.setStatus(HttpServletResponse.SC_OK);
		return category;
	}
	
//	@PostMapping({"comedyEvents","comedyEvents/"})
//	public ComedyEvent create(ComedyEvent event, HttpServletResponse res, HttpServletRequest requ) {
//		
//		try {
//			eventService.create(event);
//			res.setStatus(HttpServletResponse.SC_CREATED);
//			res.setHeader("Location", requ.getRequestURL().append("/").append(event.getId()).toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//			event = null;
//			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//		}
//		
//		return event;
//	}
//	
	
	
	}
