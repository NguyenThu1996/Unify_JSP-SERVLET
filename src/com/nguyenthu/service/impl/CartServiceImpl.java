package com.nguyenthu.service.impl;

import java.io.File;
import java.util.List;

import com.nguyenthu.dao.CartDao;
import com.nguyenthu.dao.ProductDao;
import com.nguyenthu.dao.UserDao;
import com.nguyenthu.dao.impl.CartDaoImpl;
import com.nguyenthu.dao.impl.ProductDaoImpl;
import com.nguyenthu.dao.impl.UserDaoImpl;
import com.nguyenthu.model.Cart;
import com.nguyenthu.model.Product;
import com.nguyenthu.model.User;
import com.nguyenthu.service.CartService;
import com.nguyenthu.service.ProductService;
import com.nguyenthu.service.UserService;

public class CartServiceImpl implements CartService {
	CartDao cartDao = new CartDaoImpl();

	@Override
	public List<Cart> search(String name) {
		return cartDao.search(name);
	}

	@Override
	public void insert(Cart cart) {
		cartDao.insert(cart);

	}

	@Override
	public List<Cart> getAll() {
		return cartDao.getAll();
	}

	@Override
	public Cart get(int id) {
		return cartDao.get(id);
	}

	@Override
	public void edit(Cart newCart) {
		Cart oldCart = cartDao.get(newCart.getId());

		oldCart.setBuyDate(newCart.getBuyDate());
		oldCart.setBuyer(newCart.getBuyer());
		
		
		cartDao.edit(oldCart);

	}

	@Override
	public void delete(int id) {
		cartDao.delete(id);
	}
}
