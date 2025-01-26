package com.skilldistillery.comedyevent.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class ComedianTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Comedian comedian;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAComedyEvent");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		comedian = em.find(Comedian.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		comedian = null;
		em.close();
	}

	@Test
	void test_entity_mapping() {
		assertNotNull(comedian);
		assertEquals("Beth", comedian.getFirstName());
	}
	
	@Test
	void test_ManyToOne_Category_mapping() {
		assertEquals("story telling", comedian.getCategory().getName());
	}
	
	@Test
	void test_OneToMany_ComedyEvent_mapping() {
		assertTrue(comedian.getEvents().size()>0);
	}

}
