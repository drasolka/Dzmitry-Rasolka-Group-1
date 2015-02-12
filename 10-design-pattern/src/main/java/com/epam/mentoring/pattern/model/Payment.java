package com.epam.mentoring.pattern.model;

import java.io.Serializable;

public class Payment implements Serializable {

	private Integer id;

	private Integer amount;

	private CreditCard creditCard;

	public Payment() {

	}

	public Payment(final Integer id, final Integer amount,
			final CreditCard creditCard) {
		this.id = id;
		this.amount = amount;
		this.creditCard = creditCard;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(final Integer amount) {
		this.amount = amount;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(final CreditCard creditCard) {
		this.creditCard = creditCard;
	}

}
