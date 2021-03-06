package com.epam.mentoring.ddd.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epam.mentoring.ddd.dao.PlaceDao;
import com.epam.mentoring.ddd.entity.Place;
import com.epam.mentoring.ddd.service.PlaceService;

@Stateless
public class PlaceServiceImpl implements PlaceService {

	@EJB
	private PlaceDao placeDao;

	public void create(final Place entity) {
		placeDao.create(entity);
	}

	public Place findByID(final Integer id) {
		return placeDao.findByID(id);
	}

	public Place update(final Place entity) {
		return placeDao.update(entity);
	}

	public void delete(final Place entity) {
		placeDao.delete(entity);
	}

	public Place findBySeatNumber(final Integer seatNumber) {
		return placeDao.findBySeatNumber(seatNumber);
	}

}
