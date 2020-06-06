package com.clinic.mongo.models.collections;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class LegoSetDifficulty {

	private String easy;
	private String hard;
	private String medium;
	public String getEasy() {
		return easy;
	}
	public void setEasy(String easy) {
		this.easy = easy;
	}
	public String getHard() {
		return hard;
	}
	public void setHard(String hard) {
		this.hard = hard;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	
	
}
