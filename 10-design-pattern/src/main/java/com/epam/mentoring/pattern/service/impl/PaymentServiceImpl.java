package com.epam.mentoring.pattern.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.epam.mentoring.pattern.data.ApplicationData;
import com.epam.mentoring.pattern.model.Payment;
import com.epam.mentoring.pattern.service.PaymentService;
import com.epam.mentoring.pattern.service.exception.PaymentServiceException;

public class PaymentServiceImpl implements PaymentService {

	private static final Logger LOGGER = LogManager.getLogger(PaymentServiceImpl.class);
	private List<Payment> payments;

	public PaymentServiceImpl() {
		this.payments = ApplicationData.getInstance().getPaymentList();
	}

	@Override
	public Payment getPayment(final Integer cardNumber) {
		for (final Payment payment : payments) {
			if (cardNumber.equals(payment.getCreditCard().getId())) {
				return payment;
			}
		}
		return null;
	}

	public synchronized void makePurchase(final Payment payment,
			final Integer amount) throws PaymentServiceException {
		
		final Payment updatedPayment = getPayment(payment.getCreditCard().getId());
		if (updatedPayment.getCreditCard().getBalance().compareTo(amount) < 0) {
			throw new PaymentServiceException("There is no enough money");
		}
		payment.getCreditCard().setBalance(payment.getCreditCard().getBalance() - amount);
		try {
			save(payment);
		} catch (final PaymentServiceException e) {
			LOGGER.error("Purchase with error", e);
			throw new PaymentServiceException(e);
		}
	}

	void save(final Payment paymentNew) throws PaymentServiceException {
		for (final Payment payment : payments) {
			if (payment.getId().equals(paymentNew.getId())) {
				payments.remove(paymentNew);
				break;
			}
		}
		payments.add(paymentNew);
	}

	@Override
	public void refund(final Payment payment, final Integer amount) {
		final Payment updatedPayment = getPayment(payment.getCreditCard().getId());
		updatedPayment.getCreditCard().setBalance(payment.getCreditCard().getBalance() + amount);
		try {
			save(updatedPayment);
		} catch (final PaymentServiceException e) {
			LOGGER.error("Refund with error", e);
		}
	}

}
