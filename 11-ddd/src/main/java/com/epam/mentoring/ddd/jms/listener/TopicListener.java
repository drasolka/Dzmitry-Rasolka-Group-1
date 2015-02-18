package com.epam.mentoring.ddd.jms.listener;

import java.util.Hashtable;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.naming.Context;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.epam.mentoring.ddd.dto.ReservationRequest;
import com.epam.mentoring.ddd.entity.CreditCard;
import com.epam.mentoring.ddd.entity.Place;
import com.epam.mentoring.ddd.service.CreditCardService;
import com.epam.mentoring.ddd.service.PlaceService;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/test") })
public class TopicListener implements MessageListener {

	private static final Logger logger = Logger.getLogger(TopicListener.class);

	public TopicListener() {
	}

	public void onMessage(final Message message) {
		try {

			// inital data for demo
			init();

			if (message instanceof ObjectMessage) {
				final ReservationRequest reservationRequest = ((ReservationRequest) ((ObjectMessage) message)
						.getObject());

				final Integer placeNumber = reservationRequest.getPlaceNumber();
				final Place place = getPlaceService().findBySeatNumber(
						placeNumber);

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
					throw new Exception(
							"Insufficient funds on your credit card.");
				}

				creditCard.setBalance(balance - priceReservation);
				place.setBooked(Boolean.TRUE);

				getCreditCardService().update(creditCard);
				getPlaceService().update(place);

				logger.info("You successfully booked place.");

				final CreditCard checkCard = getCreditCardService()
						.findCCByCardNumber(creditCardNumber);
				logger.info("----------------CHECK---------------BALANCE: "
						+ checkCard.getBalance());
			}

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
