package com.epam.mentoring.pattern.model.wrapper;

import com.epam.mentoring.pattern.model.CreditCard;
import com.epam.mentoring.pattern.model.Payment;

public class PaymentModelWrapper {

	private Integer id;
	private Integer amount;
	private CreditCard creditCard;

	public PaymentModelWrapper(final Payment payment) {
		this.id = payment.getId();
		this.amount = payment.getAmount();
		this.creditCard = payment.getCreditCard();
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
