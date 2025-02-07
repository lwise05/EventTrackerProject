package com.skilldistillery.comedyevent.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.comedyevent.entities.Category;
import com.skilldistillery.comedyevent.services.CategoryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
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
	
		return category;
	}
	
	@PostMapping({"categories","categories/"})
	public Category createCategory(@RequestBody Category category, HttpServletResponse res, HttpServletRequest requ) {
		
		try {
			categoryService.create(category);
			res.setStatus(HttpServletResponse.SC_CREATED); //201
			res.setHeader("Location", requ.getRequestURL().append("/").append(category.getId()).toString());
		} catch (Exception e) {
			e.printStackTrace();
			category = null;
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST); //400
		}
		
		return category;
	}

	
	@PutMapping("categories/{categoryId}")
	public Category updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody Category category, HttpServletResponse res, HttpServletRequest requ) {
		
	
		try {
			 category = categoryService.update(categoryId, category);
			res.setStatus(HttpServletResponse.SC_OK); // 200
//			res.setHeader("Location", requ.getRequestURL().append("/").append(category.getId()).toString());
			} catch(Exception e) {
				e.printStackTrace();
				res.setStatus(HttpServletResponse.SC_BAD_REQUEST); //400
			}
		return category;
	}
	
	@DeleteMapping("categories/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") int categoryId, HttpServletResponse res) {
		
		try {
			if(categoryService.deletedById(categoryId)){
				res.setStatus(HttpServletResponse.SC_OK); //200
			}
			else {
				res.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST); //400
		}
		
	}
	
	
	}
