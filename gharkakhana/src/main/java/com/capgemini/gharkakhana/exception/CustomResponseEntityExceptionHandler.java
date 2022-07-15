package com.capgemini.gharkakhana.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	public final ResponseEntity<Object> handleFoodIdentifierException(FoodIdentifierException ex, WebRequest request) {
		FoodIdentifierExceptionResponse foodIdExceptionResponse = new FoodIdentifierExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(foodIdExceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
