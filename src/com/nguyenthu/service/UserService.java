package com.nguyenthu.service;

import java.util.List;

import com.nguyenthu.model.User;

public interface UserService {
	boolean insert(User user);

	void edit(User user);

	void delete(int id);

	User get(String username);
	
	User get(int id);
	
	User login(User user);
	
	boolean register(String email, String password, String username);

	List<User> getAll();

	List<User> search(String keyword);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
	
}
