package com.epam.mentoring.pattern.transaction.model;

import com.epam.mentoring.pattern.model.Payment;

public class PaymentWrapper extends Payment {

	private Integer balance;
	private Payment payment;

	public void startTransaction(final Payment payment) {
		this.payment = payment;
		this.balance = payment.getCreditCard().getBalance();
	}

	public void commit() {
		this.payment.getCreditCard().setBalance(getBalance());
	}

	public void abort() {
		this.balance = this.payment.getCreditCard().getBalance();
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(final Integer balance) {
		this.balance = balance;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(final Payment payment) {
		this.payment = payment;
	}

}
