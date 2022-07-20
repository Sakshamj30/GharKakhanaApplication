package com.capgemini.gharkakhanaapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.gharkakhanaapi.domain.Customer;
import com.capgemini.gharkakhanaapi.domain.Order;
import com.capgemini.gharkakhanaapi.repository.OrderRepository;
import com.capgemini.gharkakhanaapi.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	public OrderRepository orderrepo;
	
	@Override
	public Order saveorUpdate(Order order) {
		return orderrepo.save(order);
	}

	@Override
	public Order findOrderByCustomer(Long orderId) {
		Order order=orderrepo.findByOrderId(orderId);
		return order;
	}

	@Override
	public Iterable<Order> finaAllOrder() {
		return orderrepo.findAll();
	}

	@Override
	public void deleteOrderByCustomer(Long orderId) {
		Order order=orderrepo.findByOrderId(orderId);
		orderrepo.delete(order);
	}

}
