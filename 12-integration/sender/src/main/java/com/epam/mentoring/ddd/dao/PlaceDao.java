package com.epam.mentoring.ddd.dao;

import com.epam.mentoring.ddd.entity.Place;

public interface PlaceDao extends GenericDao<Place, Integer> {

	Place findBySeatNumber(Integer seatNumber);
}
