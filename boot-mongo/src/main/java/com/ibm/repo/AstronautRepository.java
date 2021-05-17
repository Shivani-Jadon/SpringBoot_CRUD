package com.ibm.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.model.Astronaut;

public interface AstronautRepository extends MongoRepository<Astronaut, Integer>{

}
