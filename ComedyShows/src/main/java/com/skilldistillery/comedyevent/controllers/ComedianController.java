package com.skilldistillery.comedyevent.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.comedyevent.entities.Comedian;
import com.skilldistillery.comedyevent.services.ComedianService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class ComedianController {
	
	@Autowired
	private ComedianService comedianService;
	
	@GetMapping({"comedians", "comedians/"})
	public List<Comedian> index(){
		return comedianService.findAll();
	}
	
	@GetMapping("comedians/{comedianId}")
	public Comedian findById(@PathVariable("comedianId") int comedianId, HttpServletResponse res) {
		
		Comedian comedian = comedianService.findById(comedianId);
		
		if(comedian == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
		}
		res.setStatus(HttpServletResponse.SC_OK);
		return comedian;
	
	}
	
	@PostMapping({"comedians","comedians/"})
	public Comedian createComedian(@RequestBody Comedian comedian, HttpServletResponse res ) {
		
		try {
			comedianService.create(comedian);
			res.setStatus(HttpServletResponse.SC_CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			comedian = null;
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		return comedian;
	}
	
}
