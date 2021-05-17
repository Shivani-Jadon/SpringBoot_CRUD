package com.ibm.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.todo.entity.User;
import com.ibm.todo.pojo.Login;
import com.ibm.todo.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public int addUser(User user) {
		repo.save(user);
		return user.getUserid();
	}

	@Override
	public User getUser(int id) {
		return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
	}

	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}

	@Override
	public User authenticate(Login login) {
		return repo.findByEmailAndPassword(login.getEmail(), login.getPassword()).orElseThrow(
				() -> new IllegalArgumentException("Invalid Email or password"));
	}

}
