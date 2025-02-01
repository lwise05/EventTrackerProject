package com.skilldistillery.comedyevent;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skilldistillery.comedyevent.entities.Comedian;
import com.skilldistillery.comedyevent.repositories.ComedianRepository;

@SpringBootTest
class ComedianRepoTest {
	
	@Autowired
	private ComedianRepository comedianRepo;


	@Test
	void test_findByName() {
		List<Comedian> comedians = comedianRepo.findByFirstNameContainingOrLastNameContaining("Beth", "Hanley");
		assertNotNull(comedians);
		assertTrue(comedians.size()>0);
	}
	
	@Test
	void test_findByCategory() {
		List<Comedian> comedians = comedianRepo.findByCategory_NameContaining("story");
		assertNotNull(comedians);
		assertTrue(comedians.size()>0);
	}

}
