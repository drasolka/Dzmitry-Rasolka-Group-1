package com.epam.mentoring.hibernate.service;

import java.util.List;

import javax.ejb.Remote;

import com.epam.mentoring.hibernate.entity.Unit;

@Remote
public interface UnitService {

	void create(Unit entity);

	Unit findByID(Integer id);

	Unit update(Unit entity);

	void delete(Unit entity);

	List<Unit> findAll();
}
