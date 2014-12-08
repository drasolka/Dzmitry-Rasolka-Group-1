package com.epam.mentoring.hibernate.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epam.mentoring.hibernate.dao.UnitDao;
import com.epam.mentoring.hibernate.entity.Unit;
import com.epam.mentoring.hibernate.service.UnitService;

@Stateless
public class UnitServiceImpl implements UnitService {

	@EJB
	UnitDao unitDao;

	public void create(final Unit entity) {
		unitDao.create(entity);
	}

	public Unit findByID(final Integer id) {
		return unitDao.findByID(id);
	}

	public Unit update(final Unit entity) {
		return unitDao.update(entity);
	}

	public void delete(final Unit entity) {
		unitDao.delete(entity);
	}

	public List<Unit> findAll() {
		return unitDao.findAll();
	}

}
