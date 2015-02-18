package com.epam.mentoring.ddd.dao;

import com.epam.mentoring.ddd.entity.CreditCard;

public interface CreditCardDao extends GenericDao<CreditCard, Integer> {

	CreditCard findCCByCardNumber(Integer cardNumber);
}
