package com.skilldistillery.comedyevent.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.comedyevent.entities.ComedyEvent;
import com.skilldistillery.comedyevent.services.ComedyEventService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		res.setStatus(HttpServletResponse.SC_OK);
		return event;
	}
	
	@PostMapping({"comedyEvents","comedyEvents/"})
	public ComedyEvent createComedyEvent(@RequestBody ComedyEvent event, HttpServletResponse res, HttpServletRequest requ) {
		
		try {
			eventService.create(event);
			res.setStatus(HttpServletResponse.SC_CREATED);
			res.setHeader("Location", requ.getRequestURL().append("/").append(event.getId()).toString());
		} catch (Exception e) {
			e.printStackTrace();
			event = null;
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		return event;
	}
	
	
	
	}
