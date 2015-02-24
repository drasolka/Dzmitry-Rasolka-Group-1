package com.epam.mentoring.ddd.service;

import javax.ejb.Remote;

import com.epam.mentoring.ddd.dto.ReservationRequest;

@Remote
public interface PaymentProcessor {

	void start(ReservationRequest reservation);
}
