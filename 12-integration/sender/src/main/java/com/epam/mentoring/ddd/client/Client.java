package com.epam.mentoring.ddd.client;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.epam.mentoring.ddd.dto.ReservationRequest;
import com.epam.mentoring.ddd.service.PaymentProcessor;

public class Client {

	private static final Logger logger = Logger.getLogger(Client.class);

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

	public static PaymentProcessor getPaymentProcessor()
			throws NamingException, IOException {
		return (PaymentProcessor) getContext()
				.lookup("sender-0.0.1-SNAPSHOT/PaymentProcessorImpl!com.epam.mentoring.ddd.service.PaymentProcessor");
	}

	public static void main(final String args[]) throws Exception {

		getPaymentProcessor().start(new ReservationRequest(18, 12345, 10));

	}
}
