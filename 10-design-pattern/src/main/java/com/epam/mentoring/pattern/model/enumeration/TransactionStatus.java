package com.epam.mentoring.pattern.model.enumeration;

public enum TransactionStatus {
	SUCCEED("SUCCEED"), FAILED("FAILED"), IN_PROGRESS("IN_PROGRESS");

	private final String value;

	TransactionStatus(final String value) {
		this.value = value;
	}

	public static TransactionStatus fromValue(final String value) {
		if (value != null) {
			for (final TransactionStatus color : values()) {
				if (color.value.equals(value)) {
					return color;
				}
			}
		}

		return getDefault();
		// or throw an exception
		// throw new IllegalArgumentException("Invalid color: " + value);
	}

	public String toValue() {
		return value;
	}

	public static TransactionStatus getDefault() {
		return SUCCEED;
	}
}
