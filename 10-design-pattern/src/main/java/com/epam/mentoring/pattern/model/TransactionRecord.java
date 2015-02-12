package com.epam.mentoring.pattern.model;

import java.io.Serializable;
import java.util.Date;

import com.epam.mentoring.pattern.model.enumeration.TransactionStatus;

public class TransactionRecord implements Serializable {

	private Payment payment;
	private Reservation reservation;
	private TransactionStatus status;
	private Date date;

	public TransactionRecord(final Reservation reservation,
			final Payment payment, final Date date,
			final TransactionStatus status) {
		this.reservation = reservation;
		this.payment = payment;
		this.date = date;
		this.status = status;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(final Payment payment) {
		this.payment = payment;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(final Reservation reservation) {
		this.reservation = reservation;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(final TransactionStatus status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

}
