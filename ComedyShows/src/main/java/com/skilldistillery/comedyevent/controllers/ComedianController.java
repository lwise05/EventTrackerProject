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
		res.setStatus(HttpServletResponse.SC_OK); // 200
		return comedian;
	
	}
	
	@PostMapping({"comedians","comedians/"})
	public Comedian createComedian(@RequestBody Comedian comedian, HttpServletResponse res ) {
		
		try {
			comedianService.create(comedian);
			res.setStatus(HttpServletResponse.SC_CREATED); //201
		} catch (Exception e) {
			e.printStackTrace();
			comedian = null;
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST); //400
		}
		return comedian;
	}
	
	@PutMapping("comedians/{comedianId}")
	public Comedian updateComedian(@PathVariable("comedianId") int comedianId, @RequestBody Comedian comedian,HttpServletResponse res ) {
		
			try {
				comedian = comedianService.update(comedianId, comedian);
				res.setStatus(HttpServletResponse.SC_OK); //200
				
			} catch (Exception e) {
				e.printStackTrace();
				res.setStatus(HttpServletResponse.SC_BAD_REQUEST); //400
			}
			
			return comedian;
	}
	
	
	@DeleteMapping("comedians/{comedianId}")
	public void deleteComedian(@PathVariable("comedianId") int comedianId, HttpServletResponse res){
		
		try {
			if(comedianService.deletedById(comedianId)) {
				res.setStatus(HttpServletResponse.SC_OK); //200
			}
			else {
				res.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
			}
		} catch (Exception e) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST); //400
		}
		
	}
	
	
	
}
