package com.epam.mentoring.pattern.transaction;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.epam.mentoring.pattern.model.enumeration.TransactionStatus;
import com.epam.mentoring.pattern.transaction.component.wrapper.TransactionComponentWrapper;

class Coordinator {

	private static final Logger LOGGER = LogManager
			.getLogger(Coordinator.class);

	private final List<TransactionComponentWrapper> transactionComponentWrappers;

	public Coordinator() {
		this.transactionComponentWrappers = new ArrayList<TransactionComponentWrapper>();
	}

	public void register(
			final TransactionComponentWrapper transactionComponentWrapper) {
		this.transactionComponentWrappers.add(transactionComponentWrapper);
	}

	public void startTransaction() {
		for (final TransactionComponentWrapper wrapper : transactionComponentWrappers) {
			wrapper.startTransaction();
		}
	}

	public void commit() {
		for (final TransactionComponentWrapper wrapper : transactionComponentWrappers) {
			wrapper.commit();
		}
	}

	void abort() {
		for (final TransactionComponentWrapper wrapper : transactionComponentWrappers) {
			wrapper.abort();
		}
	}

	public TransactionStatus synchronize() {
		LOGGER.info("Synchronize");
		for (final TransactionComponentWrapper wrapper : transactionComponentWrappers) {
			LOGGER.info("Status: " + wrapper.getStatus());
			if (TransactionStatus.FAILED.equals(wrapper.getStatus())) {
				LOGGER.info("Status failed");
				abort();
				return TransactionStatus.FAILED;
			}
			commit();
		}
		return TransactionStatus.SUCCEED;
	}

}
