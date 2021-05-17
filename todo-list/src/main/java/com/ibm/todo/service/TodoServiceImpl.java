package com.ibm.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.todo.entity.Todo;
import com.ibm.todo.entity.User;
import com.ibm.todo.repo.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository repo;
	
	@Autowired
	private UserService userservice;
	
	
	@Override
	public int addTodo(Todo todo, int userid) {
		User user = userservice.getUser(userid);
		todo.setUser(user);
		repo.save(todo);
		return todo.getTodoId();
	}

	@Override
	public Todo getTodo(int id) {
		return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Todo id: " + id));
	}

	@Override
	public List<Todo> todoByUser(int userid) {
		return repo.findAllByUser(userid);
	}

	@Override
	public boolean removeTodo(int id) {
		repo.delete(repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Todo id: " + id)));
		return false;
	}

	@Override
	public Todo updateTodo(Todo todo) {
		repo.save(todo);
		return todo;
	}

}
