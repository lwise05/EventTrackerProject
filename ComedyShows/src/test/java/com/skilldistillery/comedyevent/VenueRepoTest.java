package com.skilldistillery.comedyevent;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.comedyevent.entities.Comedian;
import com.skilldistillery.comedyevent.entities.Venue;
import com.skilldistillery.comedyevent.repositories.VenueRepository;

@SpringBootTest
class VenueRepoTest {
	
	@Autowired
	private VenueRepository venueRepo;


	@Test
	void test_findByName() {
		List<Venue> venues = venueRepo.findByNameContaining("Comedy");
		assertNotNull(venues);
		assertTrue(venues.size()>0);
	}
	
	@Test
	void test_findByCity() {
		List<Venue> venues = venueRepo.findByCity("Denver");
		assertNotNull(venues);
		assertTrue(venues.size()>0);
	}
	
	@Test
	void test_findByState() {
		List<Venue> venues = venueRepo.findByState("Colorado");
		assertNotNull(venues);
		assertTrue(venues.size()>0);
	}
	

}
