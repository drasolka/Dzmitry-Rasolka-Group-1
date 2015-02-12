package com.epam.mentoring.pattern.client;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.epam.mentoring.pattern.model.CreditCard;
import com.epam.mentoring.pattern.model.Payment;
import com.epam.mentoring.pattern.model.Person;
import com.epam.mentoring.pattern.model.Reservation;
import com.epam.mentoring.pattern.model.enumeration.ReservationStatus;
import com.epam.mentoring.pattern.model.enumeration.TransactionStatus;
import com.epam.mentoring.pattern.transaction.CompositeTransactionLogic;

public class Client {

	private static final Logger LOGGER = LogManager.getLogger(Client.class);

	public static void main(final String[] args) {

		CompositeTransactionLogic transactionLogic;
		try {
			transactionLogic = getTransactionLogic();

			final CreditCard cc = new CreditCard(12345, 100);
			final Payment payment = new Payment(1, 30, cc);
			final Reservation reservation = new Reservation(1, new Person(123,
					"Andrei"), ReservationStatus.FREE);

			final TransactionStatus status = transactionLogic.buyTicket(
					payment, reservation);

			if (TransactionStatus.SUCCEED.equals(status)) {
				LOGGER.info("Ticket is successfully bought");
			} else {
				LOGGER.info("Error during transaction");
			}
		} catch (final NamingException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (final IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	private static Context getContext() throws NamingException {

		final Hashtable<String, Object> p = new Hashtable<String, Object>();
		p.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jboss.naming.remote.client.InitialContextFactory");
		p.put("jboss.naming.client.ejb.context", true);
		p.put(Context.PROVIDER_URL, "remote://127.0.0.1:4447/");
		p.put(InitialContext.SECURITY_PRINCIPAL, "andrei");
		p.put(InitialContext.SECURITY_CREDENTIALS, "pass");
		p.put("jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT",
				"false");

		final Context context = new InitialContext(p);
		return context;
	}

	public static CompositeTransactionLogic getTransactionLogic()
			throws NamingException, IOException {
		return (CompositeTransactionLogic) getContext()
				.lookup("com.epam.mentoring.pattern-0.0.1-SNAPSHOT/CompositeTransactionLogicImpl!com.epam.mentoring.pattern.transaction.CompositeTransactionLogic");
	}
}
