package com.ibm.todo.rest;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ibm.todo.entity.User;
import com.ibm.todo.pojo.Login;
import com.ibm.todo.service.UserService;

@CrossOrigin()
@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping(value = "/user", consumes = "application/json")
	public void createUser(@RequestBody User user) {
		int uid = service.addUser(user);
		System.out.println("User added with id : " + uid);
	}
	
	@GetMapping(value = "/login", produces = "application/json")
	public User validate(@RequestParam("email") String email, @RequestParam("password") String password) {
		Login login = new Login(email, password);
		System.out.println(login);
		return service.authenticate(login);
	}

	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "User logged out successfully";
	}
	
	@GetMapping(value = "/user/{userid}", produces = "application/json")
	public User getUser(@PathVariable("userid") int uid) {
		User u = service.getUser(uid);
		return u;
	}
	
	@GetMapping(value = "/users" , produces = "application/json")
	public List<User> getAllUsers() {
		return service.getAllUsers();		
	}
}
