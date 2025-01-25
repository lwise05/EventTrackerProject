package com.skilldistillery.comedyevent.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.comedyevent.entities.ComedyEvent;
import com.skilldistillery.comedyevent.services.ComedyEventService;

@RestController
@RequestMapping("api")
public class ComedyEventController {

		
	@Autowired
	private ComedyEventService eventService;
	
	
	@GetMapping({"comedyEvents", "comedyEvents/"})
	public List<ComedyEvent> index(){
		return eventService.findAll();
	}
}
