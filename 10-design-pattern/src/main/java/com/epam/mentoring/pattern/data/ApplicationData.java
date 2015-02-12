package com.epam.mentoring.pattern.data;

import java.util.ArrayList;
import java.util.List;

import com.epam.mentoring.pattern.model.CreditCard;
import com.epam.mentoring.pattern.model.Payment;
import com.epam.mentoring.pattern.model.Person;
import com.epam.mentoring.pattern.model.Reservation;
import com.epam.mentoring.pattern.model.TransactionRecord;
import com.epam.mentoring.pattern.model.enumeration.ReservationStatus;

public class ApplicationData {

	private static ApplicationData instance = new ApplicationData();

	private List<Payment> paymentList = new ArrayList<Payment>();
	private List<Reservation> reservationList = new ArrayList<Reservation>();
	private List<Person> personList = new ArrayList<Person>();
	private List<TransactionRecord> transactionRecords = new ArrayList<TransactionRecord>();

	public static synchronized ApplicationData getInstance() {
		return instance;
	}

	private ApplicationData() {

		final CreditCard cc = new CreditCard(12345, 100);
		final Payment payment = new Payment(1, 30, cc);
		paymentList.add(payment);

		final Person person = new Person(123, "Andrei");
		personList.add(person);

		final Reservation reservation = new Reservation(1, person,
				ReservationStatus.FREE);
		reservationList.add(reservation);
	}

	public List<Payment> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(final List<Payment> paymentList) {
		this.paymentList = paymentList;
	}

	public List<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(final List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(final List<Person> personList) {
		this.personList = personList;
	}

	public List<TransactionRecord> getTransactionRecords() {
		return transactionRecords;
	}

	public void setTransactionRecords(
			final List<TransactionRecord> transactionRecords) {
		this.transactionRecords = transactionRecords;
	}
}
