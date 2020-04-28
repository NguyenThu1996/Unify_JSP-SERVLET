package com.nguyenthu.dao;

import java.util.List;

import com.nguyenthu.model.User;

public interface UserDao {
	boolean insert(User user);

	void edit(User user);

	void delete(int id);

	User get(String username);
	
	User get(int id);

	List<User> getAll();

	List<User> search(String username);
	
	boolean checkExistEmail(String email);
	
	User checkLogin(User user);
	
	boolean checkExistUsername(String username);
}
