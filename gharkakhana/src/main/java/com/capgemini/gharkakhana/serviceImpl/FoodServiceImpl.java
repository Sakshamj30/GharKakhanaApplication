package com.capgemini.gharkakhana.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.gharkakhana.domain.Food;
import com.capgemini.gharkakhana.repository.FoodRepository;
import com.capgemini.gharkakhana.service.FoodService;
@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	private FoodRepository foodRepository;

	@Override
	public Food saveOrUpdate(Food food) {
		
		// business logic
		
		return foodRepository.save(food);
	}

}
