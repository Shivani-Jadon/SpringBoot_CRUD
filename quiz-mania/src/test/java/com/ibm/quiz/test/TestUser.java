package com.ibm.quiz.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.quiz.entity.User;
import com.ibm.quiz.service.UserService;

public class TestUser {
	
	@Autowired
	private UserService service;
	
	@Test
	public void testAddUser() {
		User u = new User();
		u.setUsername("Polo");
		
		service.addUser(u);
	}
}
