package com.ibm.todo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.todo.entity.Todo;
import com.ibm.todo.service.TodoService;

@CrossOrigin()
@RestController
public class TodoController {

	@Autowired
	private TodoService service;
	
	@PostMapping(value = "/todo/{userid}", consumes = "application/json")
	public void addTodo(@PathVariable("userid") int userid ,@RequestBody Todo todo) {
		int todoid = service.addTodo(todo, userid);
		System.out.println("Todo List added with id : " + todoid);
	}
	
	@GetMapping(value = "/todo/{todoid}", produces = "application/json")
	public Todo getTodo(@PathVariable("todoid") int todoid) {
		return service.getTodo(todoid);
	}
	
	@GetMapping(value = "/todo/user/{userid}", produces = "application/json")
	public List<Todo> getTodoByUser(@PathVariable("userid") int userid) {
		return service.todoByUser(userid);
	}
	
	@DeleteMapping(value = "/todo/remove/{todoid}")
	public void deleteTodo(@PathVariable("todoid") int todoid) {
		 service.removeTodo(todoid);
		 System.out.println("Todo item removed");
	}
	
//	@PostMapping(value = "/update", consumes = "application/json")
//	public String modifyTodo(@RequestBody Todo todo) {
//		service.updateTodo(todo);
//		return "Todo List updated ";
//	}
}
