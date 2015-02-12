package com.epam.mentoring.pattern.model;

import java.io.Serializable;

public class Person implements Serializable {

	private Integer id;

	private String fullName;

	public Person(final Integer id, final String fullName) {
		this.id = id;
		this.fullName = fullName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}

}
