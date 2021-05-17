package com.ibm.todo.service;

import java.util.List;

import com.ibm.todo.entity.User;
import com.ibm.todo.pojo.Login;

public interface UserService {
	
	int addUser(User user);
	
	User getUser(int id);
	
	List<User> getAllUsers();
	
	User authenticate(Login login);
}
