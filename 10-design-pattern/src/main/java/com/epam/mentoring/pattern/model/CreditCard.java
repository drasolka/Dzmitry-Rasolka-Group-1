package com.epam.mentoring.pattern.model;

import java.io.Serializable;

public class CreditCard implements Serializable {

	private Integer id;
	private Integer balance;

	public CreditCard(final Integer id, final Integer balance) {
		this.id = id;
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(final Integer balance) {
		this.balance = balance;
	}
}
