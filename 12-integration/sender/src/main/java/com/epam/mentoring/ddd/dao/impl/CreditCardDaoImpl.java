package com.epam.mentoring.ddd.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.mentoring.ddd.dao.CreditCardDao;
import com.epam.mentoring.ddd.entity.CreditCard;

@Stateless
public class CreditCardDaoImpl implements CreditCardDao {

	@PersistenceContext
	private EntityManager em;

	public void create(final CreditCard entity) {
		em.persist(entity);
	}

	public CreditCard findByID(final Integer id) {
		return em.find(CreditCard.class, id);
	}

	public CreditCard update(final CreditCard entity) {
		return em.merge(entity);
	}

	public void delete(final CreditCard entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	public CreditCard findCCByCardNumber(final Integer cardNumber) {
		final Query q = em
				.createQuery("SELECT e FROM CreditCard e WHERE e.cardNumber = :cardNumber");
		q.setParameter("cardNumber", cardNumber);
		final List<CreditCard> result = q.getResultList();
		return result != null && !result.isEmpty() ? result.get(0) : null;
	}

}
