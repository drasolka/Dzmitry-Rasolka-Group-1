package com.epam.mentoring.spring.dao;

import java.util.List;

import com.epam.mentoring.spring.entity.Session;

public interface SessionDao extends GenericDao<Session, Integer> {

	List<Session> findAll();
}
