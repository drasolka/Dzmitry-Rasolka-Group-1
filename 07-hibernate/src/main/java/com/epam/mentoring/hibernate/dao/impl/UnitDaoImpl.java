package com.epam.mentoring.hibernate.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.mentoring.hibernate.dao.UnitDao;
import com.epam.mentoring.hibernate.entity.Unit;

@Stateless
public class UnitDaoImpl implements UnitDao {

	@PersistenceContext
	private EntityManager em;

	public void create(final Unit entity) {
		em.persist(entity);
	}

	public Unit findByID(final Integer id) {
		return em.find(Unit.class, id);
	}

	public Unit update(final Unit entity) {
		return em.merge(entity);
	}

	public void delete(final Unit entity) {
		em.remove(entity);
	}

	public List<Unit> findAll() {
		final Query query = em.createQuery("from Unit");
		return query.getResultList();
	}

}
