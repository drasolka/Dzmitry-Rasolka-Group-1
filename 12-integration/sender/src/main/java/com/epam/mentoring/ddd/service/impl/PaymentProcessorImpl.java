package com.epam.mentoring.ddd.service.impl;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Hashtable;

import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.epam.mentoring.ddd.dto.AbstractObject;
import com.epam.mentoring.ddd.dto.ReservationRequest;
import com.epam.mentoring.ddd.entity.CreditCard;
import com.epam.mentoring.ddd.entity.Place;
import com.epam.mentoring.ddd.service.CreditCardService;
import com.epam.mentoring.ddd.service.PaymentProcessor;
import com.epam.mentoring.ddd.service.PlaceService;

@Stateless
public class PaymentProcessorImpl implements PaymentProcessor {

	private static final Logger logger = Logger
			.getLogger(PaymentProcessorImpl.class);

	public void start(final ReservationRequest reservationRequest) {
		try {
			init();

			final Integer placeNumber = reservationRequest.getPlaceNumber();
			final Place place = getPlaceService().findBySeatNumber(placeNumber);

			if (place.getBooked()) {
				throw new Exception("This place has already booked.");
			}

			final Integer creditCardNumber = reservationRequest
					.getCredidCardNumber();
			final Integer priceReservation = reservationRequest.getPrice();

			final CreditCard creditCard = getCreditCardService()
					.findCCByCardNumber(creditCardNumber);

			final Integer balance = creditCard.getBalance();

			if (balance < priceReservation) {
				throw new Exception("Insufficient funds on your credit card.");
			}

			creditCard.setBalance(balance - priceReservation);
			// place.setBooked(Boolean.TRUE);

			getCreditCardService().update(creditCard);
			// getPlaceService().update(place);

			// logger.info("You successfully booked place.");

			final CreditCard checkCard = getCreditCardService()
					.findCCByCardNumber(creditCardNumber);
			logger.info("----------------CHECK---------------BALANCE: "
					+ checkCard.getBalance());

			final String host = "localhost";
			final int port = 25000;
			final InetAddress address = InetAddress.getByName(host);
			final Socket socket = new Socket(address, port);
			// Send the message to the server
			final OutputStream os = socket.getOutputStream();
			final ObjectOutputStream oos = new ObjectOutputStream(os);
			final AbstractObject to = new AbstractObject();
			to.setEndpoint("endpoint2");
			to.setMessage("Place booked!");
			oos.writeObject(to);

			oos.close();
			os.close();
			socket.close();

			logger.info("Message sent");

		} catch (final JMSException e) {
			logger.error(e.getMessage(), e);
		} catch (final NamingException e) {
			logger.error(e.getMessage(), e);
		} catch (final Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	private static Context getContext() throws NamingException {
		final Hashtable props = new Hashtable();
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		return new javax.naming.InitialContext(props);
	}

	private static CreditCardService getCreditCardService()
			throws NamingException {
		return (CreditCardService) getContext()
				.lookup("java:module/CreditCardServiceImpl!com.epam.mentoring.ddd.service.CreditCardService");
	}

	private static PlaceService getPlaceService() throws NamingException {
		return (PlaceService) getContext()
				.lookup("java:module/PlaceServiceImpl!com.epam.mentoring.ddd.service.PlaceService");
	}

	private void init() throws NamingException {
		final CreditCard card = new CreditCard();
		card.setBalance(100);
		card.setCardNumber(12345);

		getCreditCardService().create(card);

		final Place place = new Place();
		place.setSeatNumber(18);
		place.setBooked(Boolean.FALSE);

		getPlaceService().create(place);
	}

}
