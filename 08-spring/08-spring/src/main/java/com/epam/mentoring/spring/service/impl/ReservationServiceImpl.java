package com.epam.mentoring.spring.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.epam.mentoring.spring.dao.ReservationDao;
import com.epam.mentoring.spring.entity.Reservation;
import com.epam.mentoring.spring.service.ReservationService;

@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Resource
	private ReservationDao reservationDao;

	@Override
	public void create(final Reservation entity) {
		reservationDao.create(entity);
	}

	@Override
	public Reservation findByID(final Integer id) {
		return reservationDao.findByID(id);
	}

	@Override
	public Reservation update(final Reservation entity) {
		return reservationDao.update(entity);
	}

	@Override
	public void delete(final Reservation entity) {
		reservationDao.delete(entity);
	}

	@Override
	public List<Reservation> findAll() {
		return reservationDao.findAll();
	}
}
