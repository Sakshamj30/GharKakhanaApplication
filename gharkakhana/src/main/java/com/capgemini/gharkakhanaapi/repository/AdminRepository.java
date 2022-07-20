package com.capgemini.gharkakhanaapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.gharkakhanaapi.domain.Admin;


@Repository
public interface AdminRepository extends CrudRepository<Admin, Long>{

	Admin findByMobileNumber(String mobileNumber);
}
