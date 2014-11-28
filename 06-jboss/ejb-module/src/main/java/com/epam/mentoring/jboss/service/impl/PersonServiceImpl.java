package com.epam.mentoring.jboss.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epam.mentoring.jboss.dao.PersonDao;
import com.epam.mentoring.jboss.model.Person;
import com.epam.mentoring.jboss.service.PersonService;

@Stateless
public class PersonServiceImpl implements PersonService {

	@EJB
	PersonDao personDao;

	public void createPerson(final String name) {
		personDao.createPerson(name);
	}

	public Person getPersonByName(final String name) {
		return personDao.getPersonByName(name);
	}

	public List<Person> getAllPerson() {
		return personDao.getAllPerson();
	}

}
