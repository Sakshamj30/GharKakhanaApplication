package com.capgemini.gharkakhanaapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.gharkakhanaapi.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

	Customer findByMobileNumber(String mobileNumber);
	

	Iterable<Customer> findAll();
}
