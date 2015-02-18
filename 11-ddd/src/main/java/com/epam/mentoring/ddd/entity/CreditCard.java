package com.epam.mentoring.ddd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreditCard implements Serializable {

	private static final long serialVersionUID = 4361120252950341946L;

	private Integer id;

	private Integer balance;

	private Integer cardNumber;

	public CreditCard() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
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

	@Column(name = "cardNumber")
	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(final Integer cardNumber) {
		this.cardNumber = cardNumber;
	}
}
