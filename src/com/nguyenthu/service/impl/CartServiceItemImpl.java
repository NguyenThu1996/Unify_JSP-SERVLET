package com.nguyenthu.service.impl;

import java.io.File;
import java.util.List;

import com.nguyenthu.dao.CartDao;
import com.nguyenthu.dao.CartItemDao;
import com.nguyenthu.dao.ProductDao;
import com.nguyenthu.dao.UserDao;
import com.nguyenthu.dao.impl.CartDaoImpl;
import com.nguyenthu.dao.impl.CartItemDaoImpl;
import com.nguyenthu.dao.impl.ProductDaoImpl;
import com.nguyenthu.dao.impl.UserDaoImpl;
import com.nguyenthu.model.Cart;
import com.nguyenthu.model.CartItem;
import com.nguyenthu.model.Product;
import com.nguyenthu.model.User;
import com.nguyenthu.service.CartItemService;
import com.nguyenthu.service.CartService;
import com.nguyenthu.service.ProductService;
import com.nguyenthu.service.UserService;

public class CartServiceItemImpl implements CartItemService {
	CartItemDao cartItemDao = new CartItemDaoImpl();

	@Override
	public void insert(CartItem cartItem) {
		cartItemDao.insert(cartItem);
		
	}

	@Override
	public void edit(CartItem newCartItem) {
		CartItem oldCartItem = cartItemDao.get(newCartItem.getId());
		oldCartItem.setCart(newCartItem.getCart());
		oldCartItem.setProduct(newCartItem.getProduct());
		oldCartItem.setQuantity(newCartItem.getQuantity());
		oldCartItem.setUnitPrice(newCartItem.getUnitPrice());
		
		cartItemDao.edit(oldCartItem);
	}

	@Override
	public void delete(String id) {
		cartItemDao.delete(id);
	}

	@Override
	public CartItem get(int id) {
		return cartItemDao.get(id);
	}

	@Override
	public List<CartItem> getAll() {
		return cartItemDao.getAll();
	}

	@Override
	public List<CartItem> search(String keyword) {
		return cartItemDao.search(keyword);
	}

	
}
