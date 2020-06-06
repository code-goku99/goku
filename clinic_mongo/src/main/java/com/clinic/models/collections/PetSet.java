package com.clinic.models.collections;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "petstore")
public class PetSet {

	@Id
	private int id;
	private String name;
	private LegoSetDifficulty difficulty;
	private String theme;
	private Collection<ProductReview> reviews = new ArrayList<>();
	@Field("deliveryInfo")
	private DeliveryInfo deliveryInformation;

	
	public PetSet(int id, String name, LegoSetDifficulty difficulty, String theme, Collection<ProductReview> reviews,
			DeliveryInfo deliveryInfo) {
		this.id = id;
		this.name = name;
		this.difficulty = difficulty;
		this.theme = theme;
		this.reviews = reviews;
		this.deliveryInformation = deliveryInfo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LegoSetDifficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(LegoSetDifficulty difficulty) {
		this.difficulty = difficulty;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public Collection<ProductReview> getReviews() {
		return reviews;
	}
	public void setReviews(Collection<ProductReview> reviews) {
		this.reviews = reviews;
	}
	public DeliveryInfo getDeliveryInformation() {
		return deliveryInformation;
	}
	public void setDeliveryInformation(DeliveryInfo deliveryInformation) {
		this.deliveryInformation = deliveryInformation;
	}
	
	
	
}
