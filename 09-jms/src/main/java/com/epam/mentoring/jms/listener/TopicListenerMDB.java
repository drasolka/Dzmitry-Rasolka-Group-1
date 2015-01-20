package com.epam.mentoring.jms.listener;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/test") })
public class TopicListenerMDB implements MessageListener {

	private static final Logger logger = Logger
			.getLogger(TopicListenerMDB.class);

	public TopicListenerMDB() {
	}

	public void onMessage(final Message message) {
		try {
			if (message instanceof TextMessage) {
				logger.info("------------------------- Recieved message: "
						+ ((TextMessage) message).getText());
			}
		} catch (final JMSException e) {
			logger.error(e.getMessage());
		}

	}
}
