package com.capgemini.gharkakhanaapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.gharkakhanaapi.domain.Customer;
import com.capgemini.gharkakhanaapi.exception.CustomerIdException;
import com.capgemini.gharkakhanaapi.repository.CustomerRepository;
import com.capgemini.gharkakhanaapi.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	
	@Override
	public Customer saveorUpdate(Customer customer) {
	
	try {
		return customerRepository.save(customer);
	}
	catch (Exception e) {
	throw new CustomerIdException("Customer Email: "+customer.getEmail()+" already exist");
	}
  }

	@Override
	public Customer findCustomerByMobileNumber(String mobileNumber) {
		Customer customer= customerRepository.findByMobileNumber(mobileNumber);
		if(customer==null)
		{
			throw new CustomerIdException("Customer Mobile Number: "+mobileNumber+" does not exist");
		}
		return customer;
	}

	@Override
	public Iterable<Customer> finaAllCustomer() {
		return customerRepository.findAll();
	
	}

	@Override
	public void deleteCustomerByCustomerMobileNumber(String mobileNumber) {
		Customer customer= customerRepository.findByMobileNumber(mobileNumber);
		if(customer==null)
		{
			throw new CustomerIdException("Customer Mobile Number: "+mobileNumber+" does not exist");
		}
		customerRepository.delete(customer);
	}
}
