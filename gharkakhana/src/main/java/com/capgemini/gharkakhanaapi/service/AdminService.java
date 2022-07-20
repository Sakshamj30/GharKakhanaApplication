package com.capgemini.gharkakhanaapi.service;

import com.capgemini.gharkakhanaapi.domain.Admin;

public interface AdminService {

public Admin saveorUpdate(Admin Admin);
	
	public Admin findAdminByAdminMobileNumber(String mobileNumber);
	
	public Iterable<Admin> finaAllAdmin();
	
	public void deleteadminByadminMobileNumber(String mobileNumber);

	void deleteAdminByAdminMobileNumber(String mobileNumber);

}
