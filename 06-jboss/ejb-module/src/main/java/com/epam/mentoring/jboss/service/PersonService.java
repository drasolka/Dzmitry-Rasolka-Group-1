package com.epam.mentoring.jboss.service;

import java.util.List;

import javax.ejb.Local;

import com.epam.mentoring.jboss.model.Person;

@Local
public interface PersonService {

	void createPerson(String name);

	Person getPersonByName(String name);

	List<Person> getAllPerson();

}
