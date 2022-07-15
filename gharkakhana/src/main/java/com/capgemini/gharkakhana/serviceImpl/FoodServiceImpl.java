package com.capgemini.gharkakhana.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.gharkakhana.domain.Food;
import com.capgemini.gharkakhana.exception.FoodIdentifierException;
import com.capgemini.gharkakhana.repository.FoodRepository;
import com.capgemini.gharkakhana.service.FoodService;
@Service
public class FoodServiceImpl implements FoodService {
	

	@Autowired
	private FoodRepository foodRepository;

	@Override
	public Food saveOrUpdate(Food food) {
		
		try {
		// business logic
			food.setFoodIdentifier(food.getFoodIdentifier().toUpperCase());
		return foodRepository.save(food);
	}catch(Exception ex) {
		throw new FoodIdentifierException("Food Identifier : "+food.getFoodIdentifier()+" already exists");
	}
	}

	@Override
	public Food findFoodByFoodIdentifier(String foodIdentifier) {
		Food food = foodRepository.findByFoodIdentifier(foodIdentifier.toUpperCase());
		if(food==null) {
			throw new FoodIdentifierException("Food Identifier : "+foodIdentifier.toUpperCase()+"does not exist");
	}
		return food;
	}
	
	@Override
	public Iterable<Food> findAllFood() {
		
		return foodRepository.findAll();
	}

	@Override
	public void deleteFoodByFoodIdentifier(String foodIdentifier) {
		// TODO Auto-generated method stub
			Food food = foodRepository.findByFoodIdentifier(foodIdentifier.toUpperCase());
			if(food==null) {
				throw new FoodIdentifierException("Food Identifier : "+foodIdentifier.toUpperCase()+"does not exist");
		}
			foodRepository.delete(food);
		
	}

	
	
	}
