package com.skilldistillery.comedyevent.services;

import java.util.List;

import com.skilldistillery.comedyevent.entities.Venue;

public interface VenueService {

	List<Venue> findAll();
	Venue findById(int id);
	Venue create(Venue venue);
	Venue update(int id, Venue venue);
	boolean deletedById (int id);
	
}
