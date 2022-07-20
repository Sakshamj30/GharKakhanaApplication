package com.capgemini.gharkakhanaapi.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.gharkakhanaapi.domain.Admin;
import com.capgemini.gharkakhanaapi.service.AdminService;
import com.capgemini.gharkakhanaapi.service.MapValidationErrorService;

@RestController
@RequestMapping("/api/admins")
public class UserController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewUser(@Valid @RequestBody Admin admin, BindingResult result)
	{
		ResponseEntity<?> errorMap= mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Admin saveAdmin= adminService.saveorUpdate(admin);
		return new ResponseEntity<Admin>(saveAdmin,HttpStatus.CREATED);
	}
	
	@GetMapping("/{mobileNumber}")
	public ResponseEntity<?> getUserById(@PathVariable String mobileNumber)
	{
		Admin admin=adminService.findAdminByAdminMobileNumber(mobileNumber);
		return new ResponseEntity<Admin>(admin,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Iterable<Admin> getAllAdmin()
	{
		return adminService.finaAllAdmin();
	}
	
	@DeleteMapping("/{mobileNumber}")
	public ResponseEntity<?> deleteOrder(@PathVariable String mobileNumber)
	{
		adminService.deleteAdminByAdminMobileNumber(mobileNumber);
		return new ResponseEntity<String>("User :"+mobileNumber+" deleted successfully",HttpStatus.OK);
	}
}
