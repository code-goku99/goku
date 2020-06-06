package com.clinic.mongo.models.collections;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "pet_set")
public class PetSet {

	@Id
	private String id;
	@TextIndexed
	private String name;
	private LegoSetDifficulty difficulty;
	@TextIndexed
	private String theme;
	private Collection<ProductReview> reviews = new ArrayList<>();
	@Field("deliveryInfo")
	private DeliveryInfo deliveryInformation;

	
	public PetSet(String name, LegoSetDifficulty difficulty, String theme, Collection<ProductReview> reviews,
			DeliveryInfo deliveryInfo) {
		this.name = name;
		this.difficulty = difficulty;
		this.theme = theme;
		this.reviews = reviews;
		this.deliveryInformation = deliveryInfo;
	}
	
	@PersistenceConstructor
	public PetSet() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
