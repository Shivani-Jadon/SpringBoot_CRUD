package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.Astronaut;
import com.ibm.repo.AstronautRepository;

@RestController
public class AstronautController {

	@Autowired
	private AstronautRepository repo;
	
	@PostMapping(value = "/add", consumes = "application/json")
	public String add(@RequestBody Astronaut astro) {
		repo.save(astro);
		return "Astronaut launced successfully";
	}
	
	@GetMapping(value = "/list", produces = "application/json")
	public List<Astronaut> allAstronaut() {
		return repo.findAll();
	}
	
	@GetMapping(value = "/astro/{astroid}", produces = "application/json")
	public Astronaut find(@PathVariable int astroid) {
		return repo.findById(astroid).get();
	}
	
	@DeleteMapping(value = "/remove/{astroid}")
	public String remove(@PathVariable int astroid) {
		repo.deleteById(astroid);
		return "Astronaut landed succcessfully";
	}
	
}
