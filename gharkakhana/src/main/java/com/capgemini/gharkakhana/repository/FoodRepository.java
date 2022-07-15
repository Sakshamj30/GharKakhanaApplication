package com.capgemini.gharkakhana.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.gharkakhana.domain.Food;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {

}
