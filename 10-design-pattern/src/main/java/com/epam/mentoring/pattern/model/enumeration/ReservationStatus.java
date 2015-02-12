package com.epam.mentoring.pattern.model.enumeration;

public enum ReservationStatus {
	FREE("FREE"), BOOKED("BOOKED");

	private final String value;

	ReservationStatus(final String value) {
		this.value = value;
	}

	public static ReservationStatus fromValue(final String value) {
		if (value != null) {
			for (final ReservationStatus color : values()) {
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

	public static ReservationStatus getDefault() {
		return FREE;
	}
}
