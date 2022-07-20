package com.capgemini.gharkakhanaapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.gharkakhanaapi.domain.Address;
import com.capgemini.gharkakhanaapi.domain.Customer;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{
Address findByAddressId(Long addressId);
	

	Iterable<Address> findAll();

}
