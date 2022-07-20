package com.capgemini.gharkakhanaapi.service;

import com.capgemini.gharkakhanaapi.domain.Food;

public interface FoodService {

	public Food saveorUpdate(Long orderId,Food food);
	
	public Food findFoodByFoodId(Long foodId);
	
	public Iterable<Food> finaAllFood();
	
	public void deleteFoodByFoodId(Long foodId);

}
