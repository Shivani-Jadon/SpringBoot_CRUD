package com.ibm.quiz.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "quiz_users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	@Column(length = 30)
	private String username;
	@Column(length = 30)
	private String password;
	@Column(length = 10)
	private String role;
	@Column(length = 10)
	private String result;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "qcode")
	private Quiz quiz;

	public int getUid() {
		return uid;
	}

	public String getUsername() {
		return username;
	}

	public String getResult() {
		return result;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
