package com.epam.mentoring.concurrency.util;

import java.util.List;

import com.epam.mentoring.concurrency.model.account.Account;
import com.epam.mentoring.concurrency.model.bank.Bank;
import com.epam.mentoring.concurrency.model.currency.Currency;
import com.epam.mentoring.concurrency.model.person.Person;

public class BankUtil {

	private static final String CURRENCY_CODE_USD = "usd";
	private static final String CURRENCY_CODE_EUR = "eur";

	public static Person hasPerson(final List<Person> persons,
			final String email) {
		for (final Person person : persons) {
			if (person.getEmail().equals(email)) {
				return person;
			}
		}
		return null;
	}

	public static Currency getCurrency(final Bank bank, final String isoCode) {
		for (final Currency curr : bank.getCurrencies()) {
			if (curr.getIsoCode().equals(isoCode)) {
				return curr;
			}
		}
		return null;
	}

	public static Account hasAccount(final String email, final Bank bank) {
		for (final Account acc : bank.getAccounts()) {
			if (acc.getPerson().getEmail().equals(email)) {
				return acc;
			}
		}
		return null;
	}

	public static Double convertCurrency(final Double amount, final Bank bank,
			final String currencyCode) {
		if (currencyCode.equals(CURRENCY_CODE_EUR)) {
			return bank.getUsdToEuroFactor() * amount;
		} else if (currencyCode.equals(CURRENCY_CODE_USD)) {
			return bank.getEuroToUsdFactor() * amount;
		}
		return amount;
	}
}
