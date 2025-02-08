package com.skilldistillery.comedyevent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.comedyevent.entities.Comedian;
import com.skilldistillery.comedyevent.entities.ComedyEvent;
import com.skilldistillery.comedyevent.entities.Venue;
import com.skilldistillery.comedyevent.repositories.ComedyEventRepository;
import com.skilldistillery.comedyevent.repositories.VenueRepository;

@Service
public class ComedyEventServiceImpl implements ComedyEventService {

	@Autowired
	private ComedyEventRepository comedyRepo;
	
	@Autowired
	private VenueRepository venueRepo;

	@Override
	public List<ComedyEvent> findAll() {
		return comedyRepo.findAll();
	}

	@Override
	public ComedyEvent findById(int id) {
		Optional<ComedyEvent> eventOpt = comedyRepo.findById(id);
		ComedyEvent event = null;
		if (eventOpt.isPresent()) {
			event = eventOpt.get();
		}
		return event;
	}

	@Override
	public ComedyEvent create(ComedyEvent event) {
		// see if comedian exists
		// if it does reassign it using event.setComedian
		// if it doesn't saveAndFlush the new comedian then
//		event.setComedian(new Comedian(1));
		// see if venue exists
		// if it does reassign it using venue.setComedian
		// if it doesn't saveAndFlush the new venue then
//		event.setVenue(new Venue(1));
		comedyRepo.saveAndFlush(event);
		return event;
	}

	@Override
	public ComedyEvent update(int id, ComedyEvent event) {
		Optional<ComedyEvent> eventOpt = comedyRepo.findById(id);
		ComedyEvent updatedEvent = null;

		if (eventOpt.isPresent()) {
			updatedEvent = eventOpt.get();
			updatedEvent.setPerformanceDate(event.getPerformanceDate());
			updatedEvent.setRating(event.getRating());
			updatedEvent.setTicketPrice(event.getTicketPrice());
			updatedEvent.setNotes(event.getNotes());
			updatedEvent.setVenue(venueRepo.findById(event.getVenue().getId()).orElse(null));
			updatedEvent.setComedian(event.getComedian());
			comedyRepo.saveAndFlush(updatedEvent);
		}

		return updatedEvent;
	}

	@Override
	public boolean deletedById(int id) {
		boolean deleted = false;
		Optional<ComedyEvent> eventOpt = comedyRepo.findById(id);
		if (eventOpt.isPresent()) {
			comedyRepo.delete(eventOpt.get());
			deleted = true;
		}
		return deleted;
	}

	@Override
	public List<ComedyEvent> findByComedian(String name) {
		List<ComedyEvent> events = comedyRepo.findByComedian_FirstNameContainingOrComedian_LastNameContaining(name,
				name);
		return events;
	}

	@Override
	public List<ComedyEvent> findByRating(int rating) {
		List<ComedyEvent> events = comedyRepo.findByRatingOrderByRatingDesc(rating);
		return events;
	}

	@Override
	public List<ComedyEvent> findByVenue(String venue) {
		List<ComedyEvent> events = comedyRepo.findByVenue_NameContaining(venue);
		return events;
	}

}
