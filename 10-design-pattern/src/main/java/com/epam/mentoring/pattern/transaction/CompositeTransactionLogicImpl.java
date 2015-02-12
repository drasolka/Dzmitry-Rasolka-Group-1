package com.epam.mentoring.pattern.transaction;

import java.util.Date;

import javax.ejb.Stateless;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.epam.mentoring.pattern.model.Payment;
import com.epam.mentoring.pattern.model.Reservation;
import com.epam.mentoring.pattern.model.TransactionRecord;
import com.epam.mentoring.pattern.model.enumeration.TransactionStatus;
import com.epam.mentoring.pattern.transaction.component.wrapper.impl.PaymentComponentWrapper;
import com.epam.mentoring.pattern.transaction.component.wrapper.impl.ReservationComponentWrapper;
import com.epam.mentoring.pattern.transaction.model.TransactionRecorder;

@Stateless
public class CompositeTransactionLogicImpl implements CompositeTransactionLogic {

	private static final Logger LOGGER = LogManager
			.getLogger(CompositeTransactionLogicImpl.class);

	private final PaymentComponentWrapper paymentComponentWrapper;
	private final ReservationComponentWrapper reservationComponentWrapper;
	private final Coordinator coordinator;

	public CompositeTransactionLogicImpl() {
		this.paymentComponentWrapper = new PaymentComponentWrapper();
		this.reservationComponentWrapper = new ReservationComponentWrapper();
		this.coordinator = new Coordinator();
	}

	@Override
	public TransactionStatus buyTicket(final Payment payment,
			final Reservation reservation) {

		this.paymentComponentWrapper.setPayment(payment);
		this.reservationComponentWrapper.setReservation(reservation);

		coordinator.register(reservationComponentWrapper);
		coordinator.register(paymentComponentWrapper);

		coordinator.startTransaction();

		this.reservationComponentWrapper.book();
		this.paymentComponentWrapper.makePurchase(payment.getAmount());

		final TransactionStatus status = this.coordinator.synchronize();

		final TransactionRecorder recorder = new TransactionRecorder();
		recorder.save(new TransactionRecord(reservation, payment, new Date(),
				status));
		return status;
	}
}
