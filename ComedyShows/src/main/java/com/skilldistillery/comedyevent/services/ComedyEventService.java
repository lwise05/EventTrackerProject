package com.skilldistillery.comedyevent.services;

import java.util.List;

import com.skilldistillery.comedyevent.entities.ComedyEvent;

public interface ComedyEventService {

	List<ComedyEvent> findAll();
	ComedyEvent findById(int id);
	ComedyEvent create(ComedyEvent event);
	ComedyEvent update(int id, ComedyEvent event);
	boolean deletedById (int id);
	
}
