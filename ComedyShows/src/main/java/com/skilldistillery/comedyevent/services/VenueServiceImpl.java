package com.skilldistillery.comedyevent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.comedyevent.entities.Venue;
import com.skilldistillery.comedyevent.repositories.VenueRepository;

@Service
public class VenueServiceImpl implements VenueService{

	@Autowired
	private VenueRepository venueRepo;

	@Override
	public List<Venue> findAll() {
		return venueRepo.findAll();
	}

	@Override
	public Venue findById(int id) {
		Optional<Venue> venueOpt = venueRepo.findById(id);
		Venue venue = null;
		if(venueOpt.isPresent()) {
			venue = venueOpt.get();
		}
		return venue;
	}

	@Override
	public Venue create(Venue venue) {
		return venueRepo.saveAndFlush(venue);
	}

	@Override
	public Venue update(int id, Venue venue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletedById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	


}
