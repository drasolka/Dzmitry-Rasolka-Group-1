package com.epam.mentoring.concurrency.task;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

import com.epam.mentoring.concurrency.model.account.Account;
import com.epam.mentoring.concurrency.model.bank.Bank;
import com.epam.mentoring.concurrency.model.currency.Currency;
import com.epam.mentoring.concurrency.model.person.Person;

public class SaveModelTask implements Runnable {

	private static final Logger logger = Logger.getLogger(SaveModelTask.class);

	private static final String BANK_MODEL = "bank";
	private static final String CURRENCY_MODEL = "currency";
	private static final String ACCOUNT_MODEL = "account";
	private static final String PERSON_MODEL = "person";

	private final BlockingQueue<String> queue;

	private final String name;
	private final Bank bank;
	private final List<Person> persons;

	public SaveModelTask(final BlockingQueue<String> queue, final Bank bank,
			final List<Person> persons, final String name) {
		this.queue = queue;
		this.bank = bank;
		this.name = name;
		this.persons = persons;

	}

	@Override
	public void run() {
		try {

			if (name.equals(CURRENCY_MODEL)) {
				for (final Currency cur : bank.getCurrencies()) {
					queue.put(cur.toString());
				}
			} else if (name.equals(BANK_MODEL)) {
				queue.put(bank.toString());
			} else if (name.equals(ACCOUNT_MODEL)) {
				for (final Account account : bank.getAccounts()) {
					queue.put(account.toString());
				}
			} else if (name.equals(PERSON_MODEL)) {
				for (final Person person : persons) {
					queue.put(person.toString());

				}
			}

		} catch (final InterruptedException e) {
			logger.info(e.getMessage());
		}
	}
}
