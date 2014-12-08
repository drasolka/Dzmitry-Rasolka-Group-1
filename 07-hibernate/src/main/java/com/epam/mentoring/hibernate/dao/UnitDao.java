package com.epam.mentoring.hibernate.dao;

import java.util.List;

import com.epam.mentoring.hibernate.entity.Unit;

public interface UnitDao extends GenericDao<Unit, Integer> {

	List<Unit> findAll();

}
