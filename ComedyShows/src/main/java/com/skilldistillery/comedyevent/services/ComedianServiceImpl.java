package com.skilldistillery.comedyevent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.comedyevent.entities.Category;
import com.skilldistillery.comedyevent.entities.Comedian;
import com.skilldistillery.comedyevent.repositories.ComedianRepository;

@Service
public class ComedianServiceImpl implements ComedianService{

	@Autowired
	private ComedianRepository comedianRepo;

	@Override
	public List<Comedian> findAll() {
		return comedianRepo.findAll();
	}

//	@Override
//	public Comedian findById(int id) {
//		Optional<Category> categoryOpt = categoryRepo.findById(id);
//		Category category = null;
//		if(categoryOpt.isPresent()) {
//			category = categoryOpt.get();
//		}
//		return category;
//	}
//
//	@Override
//	public Comedian create(Comedian category) {
//		return categoryRepo.saveAndFlush(category);
//	}
//
//	@Override
//	public Category update(int id, Category category) {
//		Optional<Category> categoryOpt = categoryRepo.findById(id);
//		Category updatedCat = null;
//		if(categoryOpt.isPresent()) {
//			 updatedCat = categoryOpt.get();
//			updatedCat.setName(category.getName());
//			categoryRepo.saveAndFlush(updatedCat);
//		}
//		return updatedCat;
//	}
//
//	@Override
//	public boolean deletedById(int id) {
//		boolean deleted = false;
//		Optional<Category> categoryOpt = categoryRepo.findById(id);
//		if(categoryOpt.isPresent()) {
//			Category category = categoryOpt.get();
//			categoryRepo.delete(category);
//			deleted = true;
//		}
//		return deleted;
//	}


	


}
