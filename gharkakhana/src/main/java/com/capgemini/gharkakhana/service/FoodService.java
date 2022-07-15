package com.capgemini.gharkakhana.service;

import com.capgemini.gharkakhana.domain.Food;

public interface FoodService {
	
	public Food saveOrUpdate(Food food);

	public Food findFoodByFoodIdentifier(String foodIdentifier);
	
	public Iterable<Food> findAllFood();
	
	public void deleteFoodByFoodIdentifier(String foodIdentifier);
}
