package com.epam.mentoring.pattern.service.impl;

import java.util.List;

import com.epam.mentoring.pattern.model.Person;
import com.epam.mentoring.pattern.service.PersonService;

public class PersonServiceImpl implements PersonService {

	private final List<Person> persons;

	public PersonServiceImpl(final List<Person> persons) {
		this.persons = persons;
	}

	public Person getId(final Integer id) {
		for (final Person person : persons) {
			if (person.getId().equals(id)) {
				return person;
			}
		}
		return null;
	}

}
