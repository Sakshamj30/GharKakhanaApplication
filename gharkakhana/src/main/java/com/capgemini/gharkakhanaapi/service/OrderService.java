package com.capgemini.gharkakhanaapi.service;

import com.capgemini.gharkakhanaapi.domain.Customer;
import com.capgemini.gharkakhanaapi.domain.Order;

public interface OrderService {

public Order saveorUpdate(Order order);
	
	public Order findOrderByCustomer(Long orderId);
	
	public Iterable<Order> finaAllOrder();
	
	public void deleteOrderByCustomer(Long orderId);

}
