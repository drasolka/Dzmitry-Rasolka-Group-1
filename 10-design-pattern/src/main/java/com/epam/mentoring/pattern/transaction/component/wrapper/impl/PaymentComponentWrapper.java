package com.epam.mentoring.pattern.transaction.component.wrapper.impl;

import com.epam.mentoring.pattern.model.Payment;
import com.epam.mentoring.pattern.model.enumeration.TransactionStatus;
import com.epam.mentoring.pattern.service.exception.PaymentServiceException;
import com.epam.mentoring.pattern.service.impl.PaymentServiceImpl;
import com.epam.mentoring.pattern.transaction.component.PaymentComponent;
import com.epam.mentoring.pattern.transaction.component.wrapper.TransactionComponentWrapper;

public class PaymentComponentWrapper implements TransactionComponentWrapper {

	private TransactionStatus status;
	private final PaymentComponent paymentComponent;
	private Payment payment;

	public PaymentComponentWrapper() {
		this.paymentComponent = new PaymentComponent();
		this.paymentComponent.setPaymentService(new PaymentServiceImpl());
	}

	@Override
	public void startTransaction() {
		this.status = TransactionStatus.IN_PROGRESS;
		this.paymentComponent.startTransaction(payment);
	}

	@Override
	public void commit() {
		this.paymentComponent.commit();
	}

	@Override
	public void abort() {
		this.paymentComponent.abort();
	}

	public void makePurchase(final Integer amount) {
		try {
			this.paymentComponent.makePurchase(amount);
			this.status = TransactionStatus.SUCCEED;
		} catch (final PaymentServiceException e) {
			this.status = TransactionStatus.FAILED;
		}
	}

	@Override
	public TransactionStatus getStatus() {
		return this.status;
	}

	/**
	 * @param payment
	 *            the paymentInfo to set
	 */
	public void setPayment(final Payment payment) {
		this.payment = payment;
	}

}
