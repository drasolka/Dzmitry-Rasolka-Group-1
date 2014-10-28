package com.epam.mentoring.concurrency.model.person;

public class Person {

	private String email;

	public Person(final String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return getEmail();
	}

}
