package com.epam.mentoring.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person implements Serializable {

	private static final long serialVersionUID = -5405707555834313992L;

	private Integer id;

	private String firstName;

	private String lastName;

	private List<Reservation> reservations;

	public Person() {
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

	@Column(name = "firstname")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastname")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	@OneToMany(mappedBy = "customer")
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(final List<Reservation> reservations) {
		this.reservations = reservations;
	}

}
