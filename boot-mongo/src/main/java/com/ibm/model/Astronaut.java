package com.ibm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Astronaut {

	@Id
	private int astroid;
	private String name;
	private String location;
	
	public int getAstroid() {
		return astroid;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public void setAstroid(int astroid) {
		this.astroid = astroid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
