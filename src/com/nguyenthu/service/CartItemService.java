package com.nguyenthu.service;

import java.util.List;

import com.nguyenthu.model.Cart;
import com.nguyenthu.model.CartItem;

public interface CartItemService {
	void insert(CartItem cartItem);

	void edit(CartItem cartItem);

	void delete(String id);

	CartItem get(int id);
	
	List<CartItem> getAll();

	List<CartItem> search(String keyword);
}
