package com.epam.mentoring.concurrency.model.currency;

public class Currency {

	private String isoCode;

	public Currency(final String isoCode) {
		this.isoCode = isoCode;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(final String isoCode) {
		this.isoCode = isoCode;
	}

	@Override
	public String toString() {
		return getIsoCode();
	}

}
