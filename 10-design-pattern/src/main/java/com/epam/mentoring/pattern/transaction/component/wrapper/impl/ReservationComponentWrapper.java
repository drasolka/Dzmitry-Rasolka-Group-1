package com.epam.mentoring.pattern.transaction.component.wrapper.impl;

import com.epam.mentoring.pattern.model.Reservation;
import com.epam.mentoring.pattern.model.enumeration.TransactionStatus;
import com.epam.mentoring.pattern.service.exception.ReservationServiceException;
import com.epam.mentoring.pattern.service.impl.ReservationServiceImpl;
import com.epam.mentoring.pattern.transaction.component.ReservationComponent;
import com.epam.mentoring.pattern.transaction.component.wrapper.TransactionComponentWrapper;

public class ReservationComponentWrapper implements TransactionComponentWrapper {

	private TransactionStatus status;
	private ReservationComponent reservationComponent;
	private Reservation reservation;

	public ReservationComponentWrapper() {
		this.reservationComponent = new ReservationComponent();
		this.reservationComponent
				.setReservationService(new ReservationServiceImpl());
	}

	@Override
	public void startTransaction() {
		this.status = TransactionStatus.IN_PROGRESS;
		this.reservationComponent.startTransaction(reservation);
	}

	@Override
	public void commit() {
		this.reservationComponent.commit();
	}

	@Override
	public void abort() {
		this.reservationComponent.abort();
	}

	public void book() {
		try {
			this.reservationComponent.book();
			this.status = TransactionStatus.SUCCEED;
		} catch (final ReservationServiceException e) {
			this.status = TransactionStatus.FAILED;
		}
	}

	@Override
	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(final TransactionStatus status) {
		this.status = status;
	}

	public ReservationComponent getReservationComponent() {
		return reservationComponent;
	}

	public void setReservationComponent(
			final ReservationComponent reservationComponent) {
		this.reservationComponent = reservationComponent;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(final Reservation reservation) {
		this.reservation = reservation;
	}

}
