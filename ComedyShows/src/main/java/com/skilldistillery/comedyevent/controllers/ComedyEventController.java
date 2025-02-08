package com.skilldistillery.comedyevent.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.comedyevent.entities.ComedyEvent;
import com.skilldistillery.comedyevent.services.ComedyEventService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin({"*", "http://localhost/"})
@RestController
@RequestMapping("api")
public class ComedyEventController {

		
	@Autowired
	private ComedyEventService eventService;
	
	
	@GetMapping({"comedyEvents", "comedyEvents/"})
	public List<ComedyEvent> index(){
		return eventService.findAll();
	}
	
	@GetMapping("comedyEvents/{comedyEventId}")
	public ComedyEvent findById(@PathVariable("comedyEventId") int comedyEventId, HttpServletResponse res) {
		
		ComedyEvent event = eventService.findById(comedyEventId);
		
		if(event == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
		}
		
		return event;
	}
	
	@PostMapping({"comedyEvents","comedyEvents/"})
	public ComedyEvent createEvent(@RequestBody ComedyEvent event, HttpServletResponse res, HttpServletRequest requ) {
		
		try {
			event = eventService.create(event);
			res.setStatus(HttpServletResponse.SC_CREATED);
			res.setHeader("Location", requ.getRequestURL().append("/").append(event.getId()).toString());
		} catch (Exception e) {
			e.printStackTrace();
			event = null;
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		return event;
	}

	@PutMapping("comedyEvents/{comedyEventId}")
	public ComedyEvent updateEvent(@PathVariable("comedyEventId") int comedyEventId, @RequestBody ComedyEvent event, HttpServletResponse res) {
		
		try {
			event = eventService.update(comedyEventId, event);
			res.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST); //400
		}
		
	return event;
	
	}
	
	@DeleteMapping("comedyEvents/{comedyEventId}")
	public void deleteEvent(@PathVariable("comedyEventId") int comedyEventId, HttpServletResponse res) {
		
		try {
			if (eventService.deletedById(comedyEventId)) {
			res.setStatus(HttpServletResponse.SC_OK); //200
			}
			else {
				res.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST); //400
		}
	}
	
	@GetMapping("comedyEvents/search/comedian/{name}")
	public List<ComedyEvent> findByComedian(@PathVariable("name") String name, HttpServletResponse res) {
		
		List<ComedyEvent>  events = eventService.findByComedian(name);
		
		if(events != null) {
			res.setStatus(HttpServletResponse.SC_OK); //200
		}
			res.setStatus(HttpServletResponse.SC_NOT_FOUND); //404	
		return events;
	}
	
	@GetMapping("comedyEvents/search/rating/{rating}")
	public List<ComedyEvent> findByRating(@PathVariable("rating") int rating, HttpServletResponse res) {
		
		List<ComedyEvent>  events = eventService.findByRating(rating);
		
		if(events == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
		}
	
		return events;
	}
	
	@GetMapping("comedyEvents/search/venue/{venue}")
	public List<ComedyEvent> findByVenue(@PathVariable("venue") String venue, HttpServletResponse res) {
		
		List<ComedyEvent>  events = eventService.findByVenue(venue);
		
		if(events == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
		}
	
		return events;
	}
	
}
