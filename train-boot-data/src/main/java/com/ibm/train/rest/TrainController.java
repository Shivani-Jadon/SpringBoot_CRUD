package com.ibm.train.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ibm.train.entity.Train;
import com.ibm.train.exception.InvalidTrainException;
import com.ibm.train.service.TrainService;

@CrossOrigin()
@RestController
public class TrainController {

	@Autowired
	private TrainService service;
	
	@PostMapping(value = "/addtrain" , consumes = "application/json")
	public String addTrain(@RequestBody Train train) {
		int code = service.addTrain(train);
		return "Train added with code: " + code;
	}
	
	@GetMapping(value = "/trains" , produces = "application/json")
	public Collection<Train> getTrains()  {
		return service.getAll();
	}
	
	@GetMapping(value = "/train/{tcode}", produces = "application/json")
	public Train getTrain(@PathVariable("tcode") int tcode) {
		
		Train t = null;
		try {
			t = service.getTrain(tcode);
		} catch (InvalidTrainException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(e.getMessage()) );
		}
		
		return t;
	}
	
	@DeleteMapping("/removetrain/{tcode}")
	public String deleteTrain(@PathVariable("tcode") int tcode) {
		
		try {
			service.removeTrain(tcode);
			return "Train removed with code: " + tcode;
		} catch (InvalidTrainException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(e.getMessage()) );
		}
	}
	
	@PutMapping(value = "/update", produces = "application/json")
	public String modifyTrain(@RequestBody Train train) {
		service.updateTrain(train);
		return "The train has been updated";
	}
}
