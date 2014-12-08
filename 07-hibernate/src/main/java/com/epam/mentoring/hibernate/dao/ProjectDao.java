package com.epam.mentoring.hibernate.dao;

import java.util.List;

import com.epam.mentoring.hibernate.entity.Project;

public interface ProjectDao extends GenericDao<Project, Integer> {

	List<Project> findAll();
}
