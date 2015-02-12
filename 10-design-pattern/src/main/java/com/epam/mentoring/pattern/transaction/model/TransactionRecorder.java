package com.epam.mentoring.pattern.transaction.model;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.epam.mentoring.pattern.data.ApplicationData;
import com.epam.mentoring.pattern.model.TransactionRecord;

public class TransactionRecorder {

    private static final Logger LOGGER = LogManager.getLogger(TransactionRecorder.class);

    public void save(final TransactionRecord record) {
        LOGGER.info("Save transaction record");
        final List<TransactionRecord> transactionRecords = ApplicationData.getInstance().getTransactionRecords();
        transactionRecords.add(record);
        ApplicationData.getInstance().setTransactionRecords(transactionRecords);
    }

}
