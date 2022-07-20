package com.capgemini.gharkakhanaapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.gharkakhanaapi.domain.Food;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long>{

  Food findByFoodId(Long productId);
    	

	Iterable<Food> findAll();
	
}
