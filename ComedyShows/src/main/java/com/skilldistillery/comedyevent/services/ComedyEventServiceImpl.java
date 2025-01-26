package com.skilldistillery.comedyevent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.comedyevent.entities.ComedyEvent;
import com.skilldistillery.comedyevent.repositories.ComedyEventRepository;

@Service
public class ComedyEventServiceImpl implements ComedyEventService{

	@Autowired
	private ComedyEventRepository comedyRepo;
	
	@Override
	public List<ComedyEvent> findAll() {
		return comedyRepo.findAll();
	}

	@Override
	public ComedyEvent findById(int id) {
		Optional<ComedyEvent> eventOpt = comedyRepo.findById(id);
		ComedyEvent event = null;
		if(eventOpt.isPresent()) {
			event = eventOpt.get();
		}
		return event;
	}

	@Override
	public ComedyEvent create(ComedyEvent event) {
		return comedyRepo.saveAndFlush(event);
	}

	@Override
	public ComedyEvent update(int id, ComedyEvent event) {
		Optional<ComedyEvent> eventOpt = comedyRepo.findById(id);
		ComedyEvent updatedEvent = null;
		
		if(eventOpt.isPresent()) {
			updatedEvent = eventOpt.get();
			updatedEvent.setPerformanceDate(event.getPerformanceDate());
			updatedEvent.setRating(event.getRating());
			updatedEvent.setTicketPrice(event.getTicketPrice());
			updatedEvent.setVenue(event.getVenue());
			updatedEvent.setComedian(event.getComedian());
			comedyRepo.saveAndFlush(updatedEvent);
		}
		
		return updatedEvent;
	}

	@Override
	public boolean deletedById(int id) {
		boolean deleted = false;
		Optional<ComedyEvent> eventOpt = comedyRepo.findById(id);
		if(eventOpt.isPresent()) {
			comedyRepo.delete(eventOpt.get());
			deleted = true;
		}
		return deleted;
	}

}
