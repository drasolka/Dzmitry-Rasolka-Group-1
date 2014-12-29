package com.epam.mentoring.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Session implements Serializable {

	private static final long serialVersionUID = -5405707555834313992L;

	private Integer id;

	private Date date;

	private Integer price;

	private String filmName;

	public Session() {
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

	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(final Integer price) {
		this.price = price;
	}

	@Column(name = "filmName")
	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(final String filmName) {
		this.filmName = filmName;
	}
}
