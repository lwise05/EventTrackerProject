package com.skilldistillery.comedyevent.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.comedyevent.entities.Comedian;
import com.skilldistillery.comedyevent.entities.ComedyEvent;

public interface ComedianRepository extends JpaRepository<Comedian, Integer>  {
	List<Comedian> findByFirstNameContainingOrLastNameContaining (String first, String last);
	
	List<Comedian> findByCategory_NameContaining (String name);
}
