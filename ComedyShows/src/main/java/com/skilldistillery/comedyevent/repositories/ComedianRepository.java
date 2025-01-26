package com.skilldistillery.comedyevent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.comedyevent.entities.Comedian;

public interface ComedianRepository extends JpaRepository<Comedian, Integer>  {

}
