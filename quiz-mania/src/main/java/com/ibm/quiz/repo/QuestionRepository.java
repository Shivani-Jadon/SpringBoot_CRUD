package com.ibm.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.quiz.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

}
