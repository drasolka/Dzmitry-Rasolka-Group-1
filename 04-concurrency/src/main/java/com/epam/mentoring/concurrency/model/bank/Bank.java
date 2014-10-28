package com.epam.mentoring.concurrency.model.bank;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.epam.mentoring.concurrency.model.account.Account;
import com.epam.mentoring.concurrency.model.currency.Currency;

public class Bank {

	private Double usdToEuroFactor;
	private Double euroToUsdFactor;
	private List<Account> accounts;
	private List<Currency> currencies;

	public Bank() {
		this.usdToEuroFactor = 0.0;
		this.euroToUsdFactor = 0.0;
		this.accounts = new CopyOnWriteArrayList<>();
		this.currencies = new CopyOnWriteArrayList<>();
	}

	public Double getUsdToEuroFactor() {
		return usdToEuroFactor;
	}

	public void setUsdToEuroFactor(final Double usdToEuroFactor) {
		this.usdToEuroFactor = usdToEuroFactor;
	}

	public Double getEuroToUsdFactor() {
		return euroToUsdFactor;
	}

	public void setEuroToUsdFactor(final Double euroToUsdFactor) {
		this.euroToUsdFactor = euroToUsdFactor;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(final List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(final List<Currency> currencies) {
		this.currencies = currencies;
	}

	@Override
	public String toString() {
		return getUsdToEuroFactor() + " " + getEuroToUsdFactor();
	}

}
