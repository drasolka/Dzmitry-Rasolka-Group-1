package com.epam.mentoring.spring.service;

import java.util.List;

import com.epam.mentoring.spring.entity.Session;

public interface SessionService {

	public void create(Session entity);

	Session findByID(Integer id);

	Session update(Session entity);

	void delete(Session entity);

	List<Session> findAll();
}
