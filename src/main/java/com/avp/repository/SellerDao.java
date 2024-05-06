package com.avp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avp.models.Seller;

public interface SellerDao extends JpaRepository<Seller, Integer> {
	
	Optional<Seller> findByMobile(String mobile);
	
}
