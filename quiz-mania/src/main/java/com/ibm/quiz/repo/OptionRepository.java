package com.ibm.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.quiz.entity.Option;

public interface OptionRepository extends JpaRepository<Option, Integer> {

}
