package com.epam.mentoring.spring.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.mentoring.spring.dao.PlaceDao;
import com.epam.mentoring.spring.entity.Place;

@Stateless
public class PlaceDaoImpl implements PlaceDao {

	@PersistenceContext
	private EntityManager em;

	public void create(final Place entity) {
		em.persist(entity);
	}

	public Place findByID(final Integer id) {
		return em.find(Place.class, id);
	}

	public Place update(final Place entity) {
		return em.merge(entity);
	}

	public void delete(final Place entity) {
		em.remove(entity);
	}

	public Place findBySeatNumber(final Integer seatNumber) {
		final Query q = em
				.createQuery("SELECT e FROM Place e WHERE e.seatNumber = :seatNumber");
		q.setParameter("seatNumber", seatNumber);
		final List<Place> result = q.getResultList();
		return result != null && !result.isEmpty() ? result.get(0) : null;
	}

}
