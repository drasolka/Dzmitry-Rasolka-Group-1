package com.epam.mentoring.concurrency.model.account;

import com.epam.mentoring.concurrency.model.currency.Currency;
import com.epam.mentoring.concurrency.model.person.Person;

public class Account {

	private Person person;
	private Currency currency;
	private Double amount;

	public Account(final Person person, final Currency currency,
			final Double amount) {
		this.person = person;
		this.currency = currency;
		this.amount = amount;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(final Person person) {
		this.person = person;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(final Currency currency) {
		this.currency = currency;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(final Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return getPerson().getEmail() + " " + getCurrency().getIsoCode() + " "
				+ getAmount();
	}
}
