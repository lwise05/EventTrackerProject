package com.skilldistillery.comedyevent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.comedyevent.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>  {

}
