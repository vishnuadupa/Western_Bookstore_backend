package com.avp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avp.models.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	Optional<Customer> findByMobile(String mobileNo);
	
	Optional<Customer> findByEmailId(String emailId);
	
	Optional<Customer> findByMobileOrEmailId(String mobileNo, String emailId);
	
}
