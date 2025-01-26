package com.skilldistillery.comedyevent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.comedyevent.entities.Category;
import com.skilldistillery.comedyevent.entities.Venue;

public interface VenueRepository extends JpaRepository<Venue, Integer>  {

}
