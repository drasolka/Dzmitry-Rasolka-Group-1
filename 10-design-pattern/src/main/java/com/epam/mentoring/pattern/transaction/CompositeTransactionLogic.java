package com.epam.mentoring.pattern.transaction;

import javax.ejb.Remote;

import com.epam.mentoring.pattern.model.Payment;
import com.epam.mentoring.pattern.model.Reservation;
import com.epam.mentoring.pattern.model.enumeration.TransactionStatus;

@Remote
public interface CompositeTransactionLogic {

	TransactionStatus buyTicket(final Payment payment,
			final Reservation reservation);

}
