package com.skilldistillery.comedyevent.services;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComedyEvent create(ComedyEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComedyEvent update(int id, ComedyEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletedById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
