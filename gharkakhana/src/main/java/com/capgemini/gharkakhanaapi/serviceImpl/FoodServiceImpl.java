package com.capgemini.gharkakhanaapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.gharkakhanaapi.domain.Food;
import com.capgemini.gharkakhanaapi.domain.Order;
import com.capgemini.gharkakhanaapi.repository.FoodRepository;
import com.capgemini.gharkakhanaapi.repository.OrderRepository;
import com.capgemini.gharkakhanaapi.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodRepository foodReository;
	
	@Autowired
	private OrderRepository orderRepository;
	@Override
	public Food saveorUpdate(Long orderId, Food food) {
		Order order=orderRepository.findByOrderId(orderId);
		order.getFoods();
		return foodReository.save(food);
	}

	@Override
	public Food findFoodByFoodId(Long foodId) {
		Food food=foodReository.findByFoodId(foodId);
		return food;
	}

	@Override
	public Iterable<Food> finaAllFood() {
		return foodReository.findAll();
	}

	@Override
	public void deleteFoodByFoodId(Long foodId) {
		Food food=foodReository.findByFoodId(foodId);
		foodReository.delete(food);
		
	}
	


}
