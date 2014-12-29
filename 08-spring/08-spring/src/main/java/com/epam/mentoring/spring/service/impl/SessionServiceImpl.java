package com.epam.mentoring.spring.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.epam.mentoring.spring.dao.SessionDao;
import com.epam.mentoring.spring.entity.Session;
import com.epam.mentoring.spring.service.SessionService;

@Transactional
public class SessionServiceImpl implements SessionService {

	@Resource
	private SessionDao sessionDao;

	@Override
	public void create(final Session entity) {
		sessionDao.create(entity);
	}

	@Override
	public Session findByID(final Integer id) {
		return sessionDao.findByID(id);
	}

	@Override
	public Session update(final Session entity) {
		return sessionDao.update(entity);
	}

	@Override
	public void delete(final Session entity) {
		sessionDao.delete(entity);
	}

	@Override
	public List<Session> findAll() {
		return sessionDao.findAll();
	}

}
