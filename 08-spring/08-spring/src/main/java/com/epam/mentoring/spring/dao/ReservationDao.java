package com.epam.mentoring.spring.dao;

import java.util.List;

import com.epam.mentoring.spring.entity.Reservation;

public interface ReservationDao extends GenericDao<Reservation, Integer> {

	List<Reservation> findAll();
}
