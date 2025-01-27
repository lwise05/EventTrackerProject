package com.skilldistillery.comedyevent.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.comedyevent.entities.ComedyEvent;

public interface ComedyEventRepository extends JpaRepository<ComedyEvent, Integer> {

	List<ComedyEvent> findByComedian_FirstNameContainingOrComedian_LastNameContaining (String first, String last);
	
	List<ComedyEvent> findByRatingOrderByRatingDesc(int rating);
	
	List<ComedyEvent> findByVenue_NameContaining (String name);
}
