package com.epam.mentoring.spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.mentoring.spring.dao.ReservationDao;
import com.epam.mentoring.spring.entity.Reservation;

public class ReservationDaoImpl implements ReservationDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(final Reservation entity) {
		em.persist(entity);
	}

	@Override
	public Reservation findByID(final Integer id) {
		return em.find(Reservation.class, id);
	}

	@Override
	public Reservation update(final Reservation entity) {
		return em.merge(entity);
	}

	@Override
	public void delete(final Reservation entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	@Override
	public List<Reservation> findAll() {
		final Query query = em.createQuery("from Reservation");
		return query.getResultList();
	}

}
