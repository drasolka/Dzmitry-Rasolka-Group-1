package com.epam.mentoring.ddd.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epam.mentoring.ddd.dao.CreditCardDao;
import com.epam.mentoring.ddd.entity.CreditCard;
import com.epam.mentoring.ddd.service.CreditCardService;

@Stateless
public class CreditCardServiceImpl implements CreditCardService {

	@EJB
	private CreditCardDao creditCardDao;

	public void create(final CreditCard entity) {
		creditCardDao.create(entity);
	}

	public CreditCard findByID(final Integer id) {
		return creditCardDao.findByID(id);
	}

	public CreditCard update(final CreditCard entity) {
		return creditCardDao.update(entity);
	}

	public void delete(final CreditCard entity) {
		creditCardDao.delete(entity);
	}

	public CreditCard findCCByCardNumber(final Integer cardNumber) {
		return creditCardDao.findCCByCardNumber(cardNumber);
	}

}
