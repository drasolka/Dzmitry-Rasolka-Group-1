package com.epam.mentoring.spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.mentoring.spring.dao.PersonDao;
import com.epam.mentoring.spring.entity.Person;

public class PersonDaoImpl implements PersonDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(final Person entity) {
		em.persist(entity);
	}

	@Override
	public Person findByID(final Integer id) {
		return em.find(Person.class, id);
	}

	@Override
	public Person update(final Person entity) {
		return em.merge(entity);
	}

	@Override
	public void delete(final Person entity) {
		em.remove(entity);
	}

	@Override
	public List<Person> findAll() {
		final Query query = em.createQuery("from Person");
		return query.getResultList();
	}

}
