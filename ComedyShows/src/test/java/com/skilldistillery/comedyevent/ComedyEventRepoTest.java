package com.skilldistillery.comedyevent;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.comedyevent.entities.ComedyEvent;
import com.skilldistillery.comedyevent.repositories.ComedyEventRepository;

@SpringBootTest
class ComedyEventRepoTest {
	
	@Autowired
	private ComedyEventRepository eventRepo;


	@Test
	void test_findByComedian() {
		List<ComedyEvent> events = eventRepo.findByComedian_FirstNameContainingOrComedian_LastNameContaining("Beth", "Hanley");
		assertNotNull(events);
		assertTrue(events.size()>0);
	}
	
	@Test
	void test_findByRating() {
		List<ComedyEvent> events = eventRepo.findByRatingOrderByRatingDesc(5);
		assertNotNull(events);
		assertTrue(events.size()>0);
	}
	
	@Test
	void test_findByVenue() {
		List<ComedyEvent> events = eventRepo.findByVenue_NameContaining("Comedy");
		assertNotNull(events);
		assertTrue(events.size()>0);
	}

}
