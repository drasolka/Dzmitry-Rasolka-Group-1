package com.epam.mentoring.pattern.model;

import java.io.Serializable;

import com.epam.mentoring.pattern.model.enumeration.ReservationStatus;

public class Reservation implements Serializable {

	private Integer id;
	private Person person;
	private ReservationStatus status;

	public Reservation() {
	}

	public Reservation(final Integer id, final Person person,
			final ReservationStatus status) {
		this.id = id;
		this.person = person;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(final Person person) {
		this.person = person;
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(final ReservationStatus status) {
		this.status = status;
	}

}
