package com.avp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avp.models.CartItem;

public interface CartItemDao extends JpaRepository<CartItem, Integer>{

}
