package com.epam.mentoring.spring.service;

import javax.ejb.Local;

import com.epam.mentoring.spring.entity.Place;

@Local
public interface PlaceService {

	public void create(Place entity);

	Place findByID(Integer id);

	Place update(Place entity);

	void delete(Place entity);

	Place findBySeatNumber(Integer seatNumber);
}
