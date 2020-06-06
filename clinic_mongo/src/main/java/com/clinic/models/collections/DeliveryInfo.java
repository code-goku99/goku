package com.clinic.models.collections;

import java.time.LocalDate;

public class DeliveryInfo {

	private LocalDate deliveryDate;
	private int deliverFee;
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
	public void setDeliverFee(int deliverFee) {
		this.deliverFee = deliverFee;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	
}
