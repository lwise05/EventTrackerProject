package com.skilldistillery.comedyevent.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.comedyevent.entities.Comedian;
import com.skilldistillery.comedyevent.entities.Venue;
import com.skilldistillery.comedyevent.services.VenueService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class VenueController {

		
	@Autowired
	private VenueService venueService;
	
	
	@GetMapping({"venues", "venues/"})
	public List<Venue> index(){
		return venueService.findAll();
	}
	
	@GetMapping("venues/{venueId}")
	public Venue findById(@PathVariable("venueId") int venueId, HttpServletResponse res) {
		
		Venue venue = venueService.findById(venueId);
		
		if(venue == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
		}
		return venue;
	}
	
	
	@PostMapping({"venues","venues/"})
	public Venue createVenue(@RequestBody Venue venue, HttpServletResponse res) {
		
		try {
			venueService.create(venue);
			res.setStatus(HttpServletResponse.SC_OK); //200
		} catch (Exception e) {
			e.printStackTrace();
			venue = null;
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST); //400
		}
		
		return venue;
	}
	
	@PutMapping("venues/{venueId}")
	public Venue updateVenue(@PathVariable("venueId") int venueId, @RequestBody Venue venue, HttpServletResponse res) {
		
		try {
			venue = venueService.update(venueId, venue);
			res.setStatus(HttpServletResponse.SC_OK); //200
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST); //400
		}
		
		return venue;
	}
	
	
	@DeleteMapping("venues/{venueId}")
	public void deleteVenue(@PathVariable("venueId") int venueId, HttpServletResponse res) {
		
		try {
			if (venueService.deletedById(venueId)) {
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
	
	@GetMapping("venues/search/name/{name}")
	public List<Venue> findByName(@PathVariable("name") String name, HttpServletResponse res){
		
		List<Venue> venues = venueService.findByName(name);
		
		if(venues == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
		}
		return venues;
	}
	

	@GetMapping("venues/search/city/{city}")
	public List<Venue> findByCity(@PathVariable("city") String city, HttpServletResponse res){
		
		List<Venue> venues = venueService.findByCity(city);
		
		if(venues == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
		}
		return venues;
	}
	
	@GetMapping("venues/search/state/{state}")
	public List<Venue> findByState(@PathVariable("state") String state, HttpServletResponse res){
		
		List<Venue> venues = venueService.findByState(state);
		
		if(venues == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
		}
		return venues;
	}
	
	}
