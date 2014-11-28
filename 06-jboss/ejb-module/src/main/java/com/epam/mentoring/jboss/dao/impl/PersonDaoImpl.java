package com.epam.mentoring.jboss.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.mentoring.jboss.dao.PersonDao;
import com.epam.mentoring.jboss.model.Person;

@Stateless
public class PersonDaoImpl implements PersonDao {

	public static final String QUERY_GET_PERSON_BY_NAME = "SELECT p FROM Person p WHERE p.name = :name";
	public static final String QUERY_GET_PERSON_BY_NAME_PARAMETER = "name";
	public static final String QUERY_GET_ALL_PERSONS = "from Person";

	@PersistenceContext
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createPerson(final String name) {
		final Person person = new Person(name);
		em.persist(person);
	}

	public List<Person> getAllPerson() {
		final Query query = em.createQuery(QUERY_GET_ALL_PERSONS);
		return query.getResultList();
	}

	public Person getPersonByName(final String name) {
		final Query query = em.createQuery(QUERY_GET_PERSON_BY_NAME);
		query.setParameter(QUERY_GET_PERSON_BY_NAME_PARAMETER, name);
		return (Person) query.getSingleResult();
	}

}
