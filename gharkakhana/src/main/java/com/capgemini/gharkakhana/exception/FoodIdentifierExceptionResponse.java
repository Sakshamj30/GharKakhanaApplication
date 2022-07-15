package com.capgemini.gharkakhana.exception;

public class FoodIdentifierExceptionResponse {

	private String foodName;

	
	public FoodIdentifierExceptionResponse(String foodName) {
		super();
		this.foodName = foodName;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	

}

