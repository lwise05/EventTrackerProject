package com.skilldistillery.comedyevent.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.comedyevent.entities.Comedian;
import com.skilldistillery.comedyevent.services.ComedianService;

@RestController
@RequestMapping("api")
public class ComedianController {
	
	@Autowired
	private ComedianService comedianService;
	
	@GetMapping({"comedians", "comedians/"})
	public List<Comedian> index(){
		return comedianService.findAll();
	}
	

}
