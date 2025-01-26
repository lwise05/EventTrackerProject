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

	@Override
	public Comedian findById(int id) {
		Optional<Comedian> comedianOpt = comedianRepo.findById(id);
		Comedian comedian = null;
		if(comedianOpt.isPresent()) {
			comedian = comedianOpt.get();
		}
		return comedian;
	}

	@Override
	public Comedian create(Comedian comedian) {
		return comedianRepo.saveAndFlush(comedian);
	}

	@Override
	public Comedian update(int id, Comedian comedian) {
		Optional<Comedian> comedianOpt = comedianRepo.findById(id);
		Comedian updatedComedian = null;
		if(comedianOpt.isPresent()) {
			updatedComedian = comedianOpt.get();
			updatedComedian.setFirstName(comedian.getFirstName());
			updatedComedian.setLastName(comedian.getLastName());
			updatedComedian.setImageUrl(comedian.getImageUrl());
			updatedComedian.setNotes(comedian.getNotes());
			updatedComedian.setCategory(comedian.getCategory());
			updatedComedian.setEvents(comedian.getEvents());
			comedianRepo.saveAndFlush(updatedComedian);
		}
		return updatedComedian;
	}

	@Override
	public boolean deletedById(int id) {
		boolean deleted = false;
		Optional<Comedian> comedianOpt = comedianRepo.findById(id);
		if(comedianOpt.isPresent()) {
			Comedian comedian = comedianOpt.get();
			comedianRepo.delete(comedian);
			deleted = true;
		}
		return deleted;
	}


	


}
