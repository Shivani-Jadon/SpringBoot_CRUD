package com.ibm.todo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "todo_master")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int todoId;
	@Column(name = "assign_date")
	private LocalDate assignDate;
	@Column(name = "finish_date")
	private LocalDate finishDate;
	@Column(length = 10)
	private String category;
	private String priority;
	private String status;
	@Column(length = 100)
	private String task;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;

	public int getTodoId() {
		return todoId;
	}

	public LocalDate getAssignDate() {
		return assignDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public String getCategory() {
		return category;
	}

	public String getPriority() {
		return priority;
	}

	public String getStatus() {
		return status;
	}

	public String getTask() {
		return task;
	}

	public User getUser() {
		return user;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public void setAssignDate(LocalDate assignDate) {
		this.assignDate = assignDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
