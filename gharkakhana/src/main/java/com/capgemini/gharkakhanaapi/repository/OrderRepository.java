package com.capgemini.gharkakhanaapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.gharkakhanaapi.domain.Customer;
import com.capgemini.gharkakhanaapi.domain.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
    Order findByOrderId(Long orderId);
			

	Iterable<Order> findAll();
}
