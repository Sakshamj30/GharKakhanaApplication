package com.capgemini.gharkakhanaapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.gharkakhanaapi.domain.Address;
import com.capgemini.gharkakhanaapi.repository.AddressRepository;
import com.capgemini.gharkakhanaapi.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Address saveorUpdate(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address findAddressById(Long addressId) {
		Address address=addressRepository.findByAddressId(addressId);
		return address;
	}

	@Override
	public Iterable<Address> finaAllAddress() {
		return addressRepository.findAll();
	}

	@Override
	public void deleteAddressByAddressId(Long addressId) {
		Address address=addressRepository.findByAddressId(addressId);
           addressRepository.delete(address);	
	}

}
