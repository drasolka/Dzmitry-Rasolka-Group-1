package com.epam.mentoring.concurrency.task;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

import com.epam.mentoring.concurrency.model.account.Account;
import com.epam.mentoring.concurrency.model.bank.Bank;
import com.epam.mentoring.concurrency.model.currency.Currency;
import com.epam.mentoring.concurrency.model.person.Person;

public class PopulateBankModelTask implements Runnable {

	private static final Logger logger = Logger
			.getLogger(PopulateBankModelTask.class);

	private static final String BANK_MODEL = "bank";
	private static final String CURRENCY_MODEL = "currency";
	private static final String ACCOUNT_MODEL = "account";

	private final BlockingQueue<String> queue;
	private final String name;
	private final Bank bank;
	private final List<Person> persons;

	public PopulateBankModelTask(final BlockingQueue<String> queue,
			final Bank bank, final List<Person> persons, final String name) {
		this.queue = queue;
		this.name = name;
		this.bank = bank;
		this.persons = persons;
	}

	@Override
	public void run() {
		String line;
		String[] lines;
		while (true) {
			try {

				line = queue.take();

				if (name.equals(BANK_MODEL)) {
					lines = line.split(" ");
					bank.setEuroToUsdFactor(Double.valueOf(lines[0]));
					bank.setUsdToEuroFactor(Double.valueOf(lines[1]));
				} else if (name.equals(CURRENCY_MODEL)) {
					bank.getCurrencies().add(new Currency(line));
				} else if (name.equals(ACCOUNT_MODEL)) {
					lines = line.split(" ");
					final Person person = getExistingPerson(lines[0]);
					final Currency currency = getExisitngCurrency(lines[1]);
					if (person != null) {
						bank.getAccounts().add(
								new Account(person, currency, Double
										.valueOf(lines[2])));
					}
				}
			} catch (final InterruptedException ex) {
				break;
			}
		}

	}

	private Person getExistingPerson(final String email) {
		for (final Person person : persons) {
			if (person.getEmail().equals(email)) {
				return person;
			}
		}
		return null;
	}

	private Currency getExisitngCurrency(final String isoCode) {
		for (final Currency curr : bank.getCurrencies()) {
			if (curr.getIsoCode().equals(isoCode)) {
				return curr;
			}
		}
		return null;
	}

}
