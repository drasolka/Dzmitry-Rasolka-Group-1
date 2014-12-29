package com.epam.mentoring.spring.service;

import java.util.List;

import com.epam.mentoring.spring.entity.Reservation;

public interface ReservationService {

	public void create(Reservation entity);

	Reservation findByID(Integer id);

	Reservation update(Reservation entity);

	void delete(Reservation entity);

	List<Reservation> findAll();
}
