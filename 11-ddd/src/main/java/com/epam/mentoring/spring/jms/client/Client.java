package com.epam.mentoring.spring.jms.client;

import java.util.Hashtable;
import java.util.Scanner;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.epam.mentoring.spring.dto.ReservationRequest;

public class Client {

	private static final Logger logger = Logger.getLogger(Client.class);

	private static final String CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String TOPIC = "jms/topic/test";
	private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String EJB_CONTEXT = "jboss.naming.client.ejb.context";
	private static final String PROVIDER_URL = "remote://127.0.0.1:4447/";
	private static final String SECURITY_PRINCIPAL = "andrei";
	private static final String SECURITY_CREDENTIALS = "pass";
	private static final String POLICY_OPTION = "jboss.naming.client.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT";
	private static final String MENU_OPTION_1 = "Press '1' to book a place";
	private static final String MENU_OPTION_2 = "Press '0' for exit";
	private static final String OPTION_RESULT = "Message send.";

	private TopicConnection conn;
	private TopicSession session;
	private Topic topic;

	public void setupPubSub() throws JMSException, NamingException {
		final InitialContext iniCtx = getContext();
		final Object tmp = iniCtx.lookup(CONNECTION_FACTORY);
		final TopicConnectionFactory tcf = (TopicConnectionFactory) tmp;
		conn = tcf.createTopicConnection();
		topic = (Topic) iniCtx.lookup(TOPIC);
		session = conn.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
		conn.start();
	}

	public void sendAsync(final ReservationRequest request)
			throws JMSException, NamingException {

		setupPubSub();

		final TopicPublisher send = session.createPublisher(topic);
		final ObjectMessage tm = session.createObjectMessage();
		tm.setObject(request);
		send.publish(tm);
		send.close();
	}

	public void stop() throws JMSException {
		conn.stop();
		session.close();
		conn.close();
	}

	private static InitialContext getContext() throws NamingException {

		final Hashtable<String, Object> p = new Hashtable<String, Object>();
		p.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
		p.put(EJB_CONTEXT, true);
		p.put(Context.PROVIDER_URL, PROVIDER_URL);
		p.put(InitialContext.SECURITY_PRINCIPAL, SECURITY_PRINCIPAL);
		p.put(InitialContext.SECURITY_CREDENTIALS, SECURITY_CREDENTIALS);
		p.put(POLICY_OPTION, "false");

		return new InitialContext(p);
	}

	public static void main(final String args[]) throws Exception {

		final Client client = new Client();

		final Scanner scanner = new Scanner(System.in);

		for (;;) {

			System.out.println("\n" + MENU_OPTION_1);
			System.out.println("\n" + MENU_OPTION_2);

			final int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				client.sendAsync(new ReservationRequest(18, 12345, 110));
				client.stop();
				System.out.println(OPTION_RESULT);
				break;
			case 0:
				System.exit(0);
			}
		}
	}
}
