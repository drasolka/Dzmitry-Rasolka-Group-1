package com.epam.mentoring.hibernate.service;

import java.util.List;

import javax.ejb.Remote;

import com.epam.mentoring.hibernate.entity.Project;

@Remote
public interface ProjectService {

	void create(Project entity);

	Project findByID(Integer id);

	Project update(Project entity);

	void delete(Project entity);

	List<Project> findAll();
}
