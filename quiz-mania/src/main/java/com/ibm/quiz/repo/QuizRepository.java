package com.ibm.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.quiz.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer>{

}
