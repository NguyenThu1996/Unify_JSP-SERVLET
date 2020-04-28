package com.nguyenthu.dao;

import java.util.List;

import com.nguyenthu.model.Cart;
import com.nguyenthu.model.CartItem;
import com.nguyenthu.model.Category;

public interface CartItemDao {
	void insert(CartItem cartItem);

	void edit(CartItem cartItem);

	void delete(String id);

	CartItem get(String name);

	CartItem get(int id);

	List<CartItem> getAll();

	List<CartItem> search(String name);
}
