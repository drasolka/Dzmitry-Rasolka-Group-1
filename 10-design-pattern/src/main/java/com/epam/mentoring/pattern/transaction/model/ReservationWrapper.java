package com.epam.mentoring.pattern.transaction.model;

import com.epam.mentoring.pattern.model.Reservation;
import com.epam.mentoring.pattern.model.enumeration.ReservationStatus;

public class ReservationWrapper extends Reservation {

	private Reservation reservation;
	private ReservationStatus status;

	public void startTransaction(final Reservation reservation) {
		this.reservation = reservation;
		this.status = reservation.getStatus();
	}

	public void commit() {
		this.reservation.setStatus(getStatus());
	}

	public void abort() {
		this.status = this.reservation.getStatus();
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(final Reservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public ReservationStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(final ReservationStatus status) {
		this.status = status;
	}

}
