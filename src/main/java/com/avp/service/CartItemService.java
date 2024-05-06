package com.avp.service;

import com.avp.models.CartDTO;
import com.avp.models.CartItem;

public interface CartItemService {
	
	public CartItem createItemforCart(CartDTO cartdto);
	
}
