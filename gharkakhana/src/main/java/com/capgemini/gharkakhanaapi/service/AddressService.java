package com.capgemini.gharkakhanaapi.service;

import com.capgemini.gharkakhanaapi.domain.Address;
import com.capgemini.gharkakhanaapi.domain.Customer;

public interface AddressService {

	public Address saveorUpdate(Address address);
	
	public Address findAddressById(Long addressId);
	
	public Iterable<Address> finaAllAddress();
	
	public void deleteAddressByAddressId(Long addressId);
}
