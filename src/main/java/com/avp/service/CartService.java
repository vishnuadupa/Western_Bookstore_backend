package com.avp.service;

import com.avp.controller.ProductNotFound;
import com.avp.exception.CartItemNotFound;
import com.avp.models.Cart;
import com.avp.models.CartDTO;


public interface CartService {
	
	public Cart addProductToCart(CartDTO cart, String token) throws CartItemNotFound;
	public Cart getCartProduct(String token);
	public Cart removeProductFromCart(CartDTO cartDto,String token) throws ProductNotFound;
//	public Cart changeQuantity(Product product,Customer customer,Integer quantity);
	
	public Cart clearCart(String token);
	
}
