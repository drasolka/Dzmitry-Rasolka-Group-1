package com.epam.mentoring.spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.mentoring.spring.dao.SessionDao;
import com.epam.mentoring.spring.entity.Session;

public class SessionDaoImpl implements SessionDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(final Session entity) {
		em.persist(entity);
	}

	@Override
	public Session findByID(final Integer id) {
		return em.find(Session.class, id);
	}

	@Override
	public Session update(final Session entity) {
		return em.merge(entity);
	}

	@Override
	public void delete(final Session entity) {
		em.remove(entity);
	}

	@Override
	public List<Session> findAll() {
		final Query query = em.createQuery("from Session");
		return query.getResultList();
	}

}
