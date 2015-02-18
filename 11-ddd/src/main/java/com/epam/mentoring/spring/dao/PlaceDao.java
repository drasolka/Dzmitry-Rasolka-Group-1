package com.epam.mentoring.spring.dao;

import com.epam.mentoring.spring.entity.Place;

public interface PlaceDao extends GenericDao<Place, Integer> {

	Place findBySeatNumber(Integer seatNumber);
}
