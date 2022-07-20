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

import com.capgemini.gharkakhanaapi.domain.Customer;
import com.capgemini.gharkakhanaapi.domain.Order;
import com.capgemini.gharkakhanaapi.service.CustomerService;
import com.capgemini.gharkakhanaapi.service.MapValidationErrorService;
import com.capgemini.gharkakhanaapi.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

		
		@Autowired
		private OrderService orderService;
		@Autowired
		private MapValidationErrorService mapValidationErrorService;
		
		@PostMapping("")
		public ResponseEntity<?> createNewOrder(@Valid @RequestBody Order order, BindingResult result)
		{
			ResponseEntity<?> errorMap= mapValidationErrorService.mapValidationError(result);
			if(errorMap!=null) return errorMap;
			Order savedOrder= orderService.saveorUpdate(order);
			return new ResponseEntity<Order>(savedOrder,HttpStatus.CREATED);
		}
		
		@GetMapping("/{orderId}")
		public ResponseEntity<?> getCustomerByEmailId(@PathVariable Long orderId)
		{
			Order order=orderService.findOrderByCustomer(orderId);
			return new ResponseEntity<Order>(order,HttpStatus.OK);
		}
		
		@GetMapping("/all")
		public Iterable<Order> getAllOrders()
		{
			return orderService.finaAllOrder();
		}
		
		@DeleteMapping("/{orderId}")
		public ResponseEntity<?> deleteOrder(@PathVariable Long orderId)
		{
			orderService.deleteOrderByCustomer(orderId);
			return new ResponseEntity<String>("Customer :"+orderId+" deleted successfully",HttpStatus.OK);
		}
	}
