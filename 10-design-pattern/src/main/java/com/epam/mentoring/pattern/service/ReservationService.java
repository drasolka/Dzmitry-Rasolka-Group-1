package com.epam.mentoring.pattern.service;

import com.epam.mentoring.pattern.model.Reservation;
import com.epam.mentoring.pattern.service.exception.ReservationServiceException;

public interface ReservationService {

	void book(Reservation reservation) throws ReservationServiceException;

	Reservation getReservation(Integer id);

	void returnReservation(Reservation reservation)
			throws ReservationServiceException;
}
