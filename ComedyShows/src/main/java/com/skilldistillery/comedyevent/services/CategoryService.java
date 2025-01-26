package com.skilldistillery.comedyevent.services;

import java.util.List;

import com.skilldistillery.comedyevent.entities.Category;

public interface CategoryService {

	List<Category> findAll();
	Category findById(int id);
	Category create(Category cateogry);
	Category update(int id, Category ategory);
	boolean deletedById (int id);
	
}
