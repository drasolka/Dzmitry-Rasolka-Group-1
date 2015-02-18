package com.epam.mentoring.spring.service;

import javax.ejb.Local;

import com.epam.mentoring.spring.entity.CreditCard;

@Local
public interface CreditCardService {

	public void create(CreditCard entity);

	CreditCard findByID(Integer id);

	CreditCard update(CreditCard entity);

	void delete(CreditCard entity);

	CreditCard findCCByCardNumber(Integer cardNumber);
}
