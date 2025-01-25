package com.skilldistillery.comedyevent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.comedyevent.entities.ComedyEvent;

public interface ComedyEventRepository extends JpaRepository<ComedyEvent, Integer> {

}
