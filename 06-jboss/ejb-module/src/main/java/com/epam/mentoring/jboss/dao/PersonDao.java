package com.epam.mentoring.jboss.dao;

import java.util.List;

import javax.ejb.Local;

import com.epam.mentoring.jboss.model.Person;

@Local
public interface PersonDao {

	void createPerson(String name);

	Person getPersonByName(String name);

	List<Person> getAllPerson();
}
