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
		Optional<Venue> venueOpt = venueRepo.findById(id);
		Venue updatedVenue = null;
		if(venueOpt.isPresent()) {
			updatedVenue = venueOpt.get();
			updatedVenue.setName(venue.getName());	
			updatedVenue.setImageUrl(venue.getImageUrl());	
			updatedVenue.setStreet(venue.getStreet());	
			updatedVenue.setStreet2(venue.getStreet2());	
			updatedVenue.setCity(venue.getCity());	
			updatedVenue.setState(venue.getState());	
			updatedVenue.setPostalCode(venue.getPostalCode());
			updatedVenue.setCountry(venue.getCountry());
			venueRepo.saveAndFlush(updatedVenue);
		}
		return updatedVenue;
	}

	@Override
	public boolean deletedById(int id) {
		boolean deleted = false;
		Optional<Venue> venueOpt = venueRepo.findById(id);
		if(venueOpt.isPresent()) {
			venueRepo.delete(venueOpt.get());
			deleted = true;
		}
		return deleted;
	}

	


}
