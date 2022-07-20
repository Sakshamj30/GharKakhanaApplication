package com.capgemini.gharkakhanaapi.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.gharkakhanaapi.domain.Food;
import com.capgemini.gharkakhanaapi.service.FoodService;
import com.capgemini.gharkakhanaapi.service.MapValidationErrorService;

@RestController
@RequestMapping("api/foods")
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewProduct(@Valid @RequestBody Food food, BindingResult result,@PathVariable Long orderId)
	{
		ResponseEntity<?> errorMap= mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Food savedFood= foodService.saveorUpdate(orderId, food);
		return new ResponseEntity<Food>(savedFood,HttpStatus.CREATED);
	}
	
	@GetMapping("/{foodId}")
	public ResponseEntity<?> getFoodByProductId(@PathVariable Long foodId)
	{
		Food food=foodService.findFoodByFoodId(foodId);
		return new ResponseEntity<Food>(food,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Iterable<Food> getAllFood()
	{
		return foodService.finaAllFood();
	}
	
	@DeleteMapping("/{foodId}")
	public ResponseEntity<?> deleteFood(@PathVariable Long foodId)
	{
		foodService.deleteFoodByFoodId(foodId);
		return new ResponseEntity<String>("Product Id :"+foodId+" deleted successfully",HttpStatus.OK);
	}
}
