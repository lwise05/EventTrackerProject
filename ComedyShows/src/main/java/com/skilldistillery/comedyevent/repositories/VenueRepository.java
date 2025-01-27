package com.skilldistillery.comedyevent.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.comedyevent.entities.Venue;

public interface VenueRepository extends JpaRepository<Venue, Integer>  {

	List<Venue> findByNameContaining (String name);
	
	List<Venue> findByCity (String city);
	
	List<Venue> findByState (String state);
}
