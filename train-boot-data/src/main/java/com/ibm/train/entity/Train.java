package com.ibm.train.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Train {
	@Id
	@GeneratedValue
	@Column(name = "train_no")
	private int tcode;
	@Column(name = "train_name", length=30)
	private String name;
	@Column(length=20)
	private String source;
	@Column(length=20)
	private String destination;
	
	public Train() {
	}
	
	public Train(int tcode, String name, String source, String destination) {
		this.tcode = tcode;
		this.name = name;
		this.source = source;
		this.destination = destination;
	}

	public String getName() {
		return name;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getTcode() {
		return tcode;
	}

	public void setTcode(int tcode) {
		this.tcode = tcode;
	}
	
}
