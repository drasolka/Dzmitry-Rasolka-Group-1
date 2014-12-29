package com.epam.mentoring.spring.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.epam.mentoring.spring.dao.PersonDao;
import com.epam.mentoring.spring.entity.Person;
import com.epam.mentoring.spring.service.PersonService;

@Transactional
public class PersonServiceImpl implements PersonService {

	@Resource
	private PersonDao personDao;

	@Override
	public void create(final Person entity) {
		personDao.create(entity);
	}

	@Override
	public Person findByID(final Integer id) {
		return personDao.findByID(id);
	}

	@Override
	public Person update(final Person entity) {
		return personDao.update(entity);
	}

	@Override
	public void delete(final Person entity) {
		personDao.delete(entity);
	}

	@Override
	public List<Person> findAll() {
		return personDao.findAll();
	}

	@PostConstruct
	public void postConstruct() {
		System.out.print("PostConstruct PersonService");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.print("PreDestroy PersonService");
	}

}
