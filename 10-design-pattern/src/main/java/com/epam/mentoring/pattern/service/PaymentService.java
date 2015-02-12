package com.epam.mentoring.pattern.service;

import com.epam.mentoring.pattern.model.Payment;
import com.epam.mentoring.pattern.service.exception.PaymentServiceException;

public interface PaymentService {

	void makePurchase(Payment payment, Integer amount)
			throws PaymentServiceException;

	Payment getPayment(Integer cardNumber);

	void refund(Payment payment, Integer amount);
}
