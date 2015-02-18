package com.epam.mentoring.ddd.dto;

import java.io.Serializable;

public class ReservationRequest implements Serializable {

	private static final long serialVersionUID = 858541712661193487L;

	private Integer placeNumber;

	private Integer credidCardNumber;

	private Integer price;

	public ReservationRequest(final Integer placeNumber,
			final Integer creditCardNumber, final Integer price) {
		this.placeNumber = placeNumber;
		this.credidCardNumber = creditCardNumber;
		this.price = price;
	}

	public Integer getPlaceNumber() {
		return placeNumber;
	}

	public void setPlaceNumber(final Integer placeNumber) {
		this.placeNumber = placeNumber;
	}

	public Integer getCredidCardNumber() {
		return credidCardNumber;
	}

	public void setCredidCardNumber(final Integer credidCardNumber) {
		this.credidCardNumber = credidCardNumber;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(final Integer price) {
		this.price = price;
	}

}
