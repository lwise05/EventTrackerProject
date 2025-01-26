package com.skilldistillery.comedyevent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.comedyevent.entities.Category;
import com.skilldistillery.comedyevent.entities.ComedyEvent;
import com.skilldistillery.comedyevent.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}

	@Override
	public Category findById(int id) {
		Optional<Category> categoryOpt = categoryRepo.findById(id);
		Category category = null;
		if(categoryOpt.isPresent()) {
			category = categoryOpt.get();
		}
		return category;
	}

	@Override
	public Category create(Category cateogry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category update(int id, Category ategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletedById(int id) {
		// TODO Auto-generated method stub
		return false;
	}


	


}
