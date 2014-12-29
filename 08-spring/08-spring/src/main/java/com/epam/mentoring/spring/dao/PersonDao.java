package com.epam.mentoring.spring.dao;

import java.util.List;

import com.epam.mentoring.spring.entity.Person;

public interface PersonDao extends GenericDao<Person, Integer> {

	List<Person> findAll();
}
