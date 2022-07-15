package com.capgemini.gharkakhana.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.gharkakhana.domain.Food;
import com.capgemini.gharkakhana.service.FoodService;



@RestController
@RequestMapping("/api/foods")
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@PostMapping
	public ResponseEntity<?> createdNewFood(@Valid @RequestBody Food food, BindingResult result) {
		if(result.hasErrors() ) 
		{
			Map<String, String> errorMap = new HashMap<>();
			for(FieldError fieldError:result.getFieldErrors()) {
				errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
		}
		Food savedFood = foodService.saveOrUpdate(food);
		return new ResponseEntity<Food>(savedFood,HttpStatus.CREATED);
	}
	
	@GetMapping("/{foodIdentifier}")
	public ResponseEntity<?> getFoodByIdentifier(@PathVariable String foodIdentifier){
		Food food = foodService.findFoodByFoodIdentifier(foodIdentifier);
		return new ResponseEntity<Food>(food,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/all")
	public Iterable<Food> getAllFoods(){
		return foodService.findAllFood();
	}
	@DeleteMapping("/{foodIdentifier}")
	public ResponseEntity<?> deleteFood (@PathVariable String foodIdentifier){
		
		foodService.deleteFoodByFoodIdentifier(foodIdentifier);
		return new ResponseEntity<String>("Food with Identifier " +foodIdentifier+" deleted successfully",HttpStatus.OK);		
	}
}
