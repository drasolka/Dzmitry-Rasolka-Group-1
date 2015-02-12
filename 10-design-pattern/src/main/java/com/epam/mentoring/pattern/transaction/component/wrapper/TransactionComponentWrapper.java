package com.epam.mentoring.pattern.transaction.component.wrapper;

import com.epam.mentoring.pattern.model.enumeration.TransactionStatus;

public interface TransactionComponentWrapper {

	void startTransaction();

	void commit();

	void abort();

	TransactionStatus getStatus();

}
