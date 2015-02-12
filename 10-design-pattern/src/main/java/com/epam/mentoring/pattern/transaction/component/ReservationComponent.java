package com.epam.mentoring.pattern.transaction.component;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.epam.mentoring.pattern.model.Reservation;
import com.epam.mentoring.pattern.service.ReservationService;
import com.epam.mentoring.pattern.service.exception.ReservationServiceException;
import com.epam.mentoring.pattern.transaction.model.ReservationWrapper;

public class ReservationComponent {

	private static final Logger LOGGER = LogManager
			.getLogger(ReservationComponent.class);
	private ReservationWrapper reservationWrapper;
	private ReservationService reservationService;

	public ReservationComponent() {
		this.reservationWrapper = new ReservationWrapper();
	}

	public void startTransaction(final Reservation reservation) {
		this.reservationWrapper.startTransaction(reservation);
	}

	public void commit() {
		this.reservationWrapper.commit();
	}

	public void abort() {
		this.reservationWrapper.abort();
		try {
			this.reservationService.returnReservation(this.reservationWrapper);
		} catch (final ReservationServiceException e) {
			LOGGER.error("Abort transaction for reason:", e);
		}
	}

	public void book() throws ReservationServiceException {
		this.reservationService.book(this.reservationWrapper.getReservation());
	}

	public ReservationWrapper getReservationWrapper() {
		return reservationWrapper;
	}

	public void setReservationWrapper(
			final ReservationWrapper reservationWrapper) {
		this.reservationWrapper = reservationWrapper;
	}

	public ReservationService getReservationService() {
		return reservationService;
	}

	public void setReservationService(
			final ReservationService reservationService) {
		this.reservationService = reservationService;
	}

}
