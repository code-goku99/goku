package com.clinic.mongo.models.collections;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DeliveryInfo {

	private LocalDate deliveryDate;
	private Integer deliverFee;
	private boolean inStock;
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public int getDeliverFee() {
		return deliverFee;
	}
	public void setDeliverFee(Integer deliverFee) {
		this.deliverFee = deliverFee;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	
}
