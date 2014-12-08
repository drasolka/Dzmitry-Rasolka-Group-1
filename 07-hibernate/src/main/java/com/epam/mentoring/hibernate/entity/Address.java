package com.epam.mentoring.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3049082069044928352L;

	private String city;

	private String street;

	public Address() {
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	@Column(name = "street")
	public String getStreet() {
		return street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

}
