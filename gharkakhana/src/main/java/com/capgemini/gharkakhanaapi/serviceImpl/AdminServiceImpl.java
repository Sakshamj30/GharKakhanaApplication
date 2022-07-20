package com.capgemini.gharkakhanaapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.gharkakhanaapi.domain.Admin;
import com.capgemini.gharkakhanaapi.exception.AdminIdException;
import com.capgemini.gharkakhanaapi.repository.AdminRepository;
import com.capgemini.gharkakhanaapi.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin saveorUpdate(Admin admin) {
		try {
		return adminRepository.save(admin);
		}
		catch (Exception e) {
			throw new AdminIdException("User with number "+admin.getMobileNumber()+"already exist");
		}
		
	}

	@Override
	public Admin findAdminByAdminMobileNumber(String mobileNumber) {
		Admin admin=adminRepository.findByMobileNumber(mobileNumber);
		if(admin==null)
		{
			throw new AdminIdException("User mobile Number "+mobileNumber+" not exist");
		}
		return admin;
	}

	@Override
	public Iterable<Admin> finaAllAdmin() {
		return adminRepository.findAll();
	}

	@Override
	public void deleteAdminByAdminMobileNumber(String mobileNumber) {
		Admin admin=adminRepository.findByMobileNumber(mobileNumber);
		if(admin==null)
		{
			throw new AdminIdException("User mobile Number "+mobileNumber+" not exist");
		}
		adminRepository.delete(admin);
	}

	@Override
	public void deleteadminByadminMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		
	}

}
