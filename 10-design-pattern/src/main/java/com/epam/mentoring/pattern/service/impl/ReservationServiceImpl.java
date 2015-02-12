package com.epam.mentoring.pattern.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.epam.mentoring.pattern.data.ApplicationData;
import com.epam.mentoring.pattern.model.Reservation;
import com.epam.mentoring.pattern.model.enumeration.ReservationStatus;
import com.epam.mentoring.pattern.service.ReservationService;
import com.epam.mentoring.pattern.service.exception.ReservationServiceException;

public class ReservationServiceImpl implements ReservationService {

	private static final Logger LOGGER = LogManager
			.getLogger(ReservationServiceImpl.class);
	private final List<Reservation> reservations;

	public ReservationServiceImpl() {
		this.reservations = ApplicationData.getInstance().getReservationList();
	}

	@Override
	public synchronized void book(final Reservation reservation)
			throws ReservationServiceException {

		if (ReservationStatus.BOOKED.toValue().equals(
				getReservation(reservation.getId()).getStatus().toValue())) {
			throw new ReservationServiceException(
					"The ticket is already booked. id=" + reservation.getId());
		}
		reservation.setStatus(ReservationStatus.BOOKED);
		try {
			save(reservation);
		} catch (final ReservationServiceException e) {
			LOGGER.error("Booking ticket with error", e);
		}

	}

	private void save(final Reservation reservation)
			throws ReservationServiceException {

		for (final Reservation listreservation : reservations) {
			if (listreservation.getId().equals(reservation.getId())) {
				reservations.remove(listreservation);
				break;
			}
		}
		reservations.add(reservation);
	}

	@Override
	public Reservation getReservation(final Integer id) {
		for (final Reservation reservation : reservations) {
			LOGGER.info(reservation.getId());
			if (reservation.getId().equals(id)) {
				return reservation;
			}
		}
		return null;
	}

	@Override
	public void returnReservation(Reservation reservation)
			throws ReservationServiceException {
		reservation = getReservation(reservation.getId());
		reservation.setStatus(ReservationStatus.FREE);
		try {
			save(reservation);
		} catch (final ReservationServiceException e) {
			LOGGER.error("Return ticket with error", e);
		}

	}

}
