package com.epam.mentoring.ddd.dto;

import java.io.Serializable;

public class AbstractObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9165530834516077809L;
	private String endpoint;
	private String message;

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(final String endpoint) {
		this.endpoint = endpoint;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

}
