package com.ibm.train.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.train.entity.Train;

public interface TrainRepository extends JpaRepository<Train, Integer> {
	
}
