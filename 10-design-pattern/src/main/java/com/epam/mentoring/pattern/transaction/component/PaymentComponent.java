package com.epam.mentoring.pattern.transaction.component;

import com.epam.mentoring.pattern.model.Payment;
import com.epam.mentoring.pattern.service.PaymentService;
import com.epam.mentoring.pattern.service.exception.PaymentServiceException;
import com.epam.mentoring.pattern.transaction.model.PaymentWrapper;

public class PaymentComponent {

	private final PaymentWrapper paymentWrapper;
	private PaymentService paymentService;

	public PaymentComponent() {
		this.paymentWrapper = new PaymentWrapper();
	}

	public void startTransaction(final Payment payment) {
		this.paymentWrapper.startTransaction(payment);
	}

	public void commit() {
		this.paymentWrapper.commit();
	}

	public void abort() {
		final Integer newAmount = this.paymentWrapper.getBalance();

		this.paymentWrapper.abort();

		final Integer oldAmount = this.paymentWrapper.getBalance();
		if (oldAmount.compareTo(newAmount) > 0) {
			this.paymentService.refund(this.paymentWrapper, oldAmount
					- newAmount);
		}
	}

	public void makePurchase(final Integer amount)
			throws PaymentServiceException {
		this.paymentService.makePurchase(this.paymentWrapper.getPayment(),
				amount);
	}

	/**
	 * @return the paymentService
	 */
	public PaymentService getPaymentService() {
		return paymentService;
	}

	/**
	 * @param paymentService
	 *            the paymentService to set
	 */
	public void setPaymentService(final PaymentService paymentService) {
		this.paymentService = paymentService;
	}

}
