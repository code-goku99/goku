package com.clinic.mongo.models.collections;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Startuplog {

	private String hostname;

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	
}
