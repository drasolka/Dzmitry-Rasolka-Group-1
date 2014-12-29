package com.epam.mentoring.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation implements Serializable {

	private static final long serialVersionUID = -5405707555834313992L;

	private Integer id;

	private String filmName;

	private Date date;

	private Integer place;

	private Integer price;

	private Person customer;

	public Reservation() {
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

	@Column(name = "filmName")
	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(final String filmName) {
		this.filmName = filmName;
	}

	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	@Column(name = "place")
	public Integer getPlace() {
		return place;
	}

	public void setPlace(final Integer place) {
		this.place = place;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return price;
	}

	public void setPrice(final Integer price) {
		this.price = price;
	}

	@ManyToOne
	@JoinColumn(name = "customer_id")
	public Person getCustomer() {
		return customer;
	}

	public void setCustomer(final Person customer) {
		this.customer = customer;
	}

}
