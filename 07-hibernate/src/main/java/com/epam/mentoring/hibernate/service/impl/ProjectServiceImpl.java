package com.epam.mentoring.hibernate.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epam.mentoring.hibernate.dao.ProjectDao;
import com.epam.mentoring.hibernate.entity.Project;
import com.epam.mentoring.hibernate.service.ProjectService;

@Stateless
public class ProjectServiceImpl implements ProjectService {

	@EJB
	ProjectDao projectDao;

	public void create(final Project entity) {
		projectDao.create(entity);
	}

	public Project findByID(final Integer id) {
		return projectDao.findByID(id);
	}

	public Project update(final Project entity) {
		return projectDao.update(entity);
	}

	public void delete(final Project entity) {
		projectDao.delete(entity);
	}

	public List<Project> findAll() {
		return projectDao.findAll();
	}

}
