package com.epam.mentoring.spring.service;

import java.util.List;

import com.epam.mentoring.spring.entity.Person;

public interface PersonService {

	public void create(Person entity);

	Person findByID(Integer id);

	Person update(Person entity);

	void delete(Person entity);

	List<Person> findAll();
}
