package com.skilldistillery.comedyevent.services;

import java.util.List;

import com.skilldistillery.comedyevent.entities.Comedian;

public interface ComedianService {

	List<Comedian> findAll();
	Comedian findById(int id);
	Comedian create(Comedian comedian);
	Comedian update(int id, Comedian comedian);
	boolean deletedById (int id);
	
	List<Comedian> findByName(String name);
	List<Comedian> findByCategory(String name);
}
