package com.epam.mentoring.spring.dao;

import com.epam.mentoring.spring.entity.CreditCard;

public interface CreditCardDao extends GenericDao<CreditCard, Integer> {

	CreditCard findCCByCardNumber(Integer cardNumber);
}
