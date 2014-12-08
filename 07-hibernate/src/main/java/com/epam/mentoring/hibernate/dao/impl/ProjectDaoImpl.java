package com.epam.mentoring.hibernate.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.mentoring.hibernate.dao.ProjectDao;
import com.epam.mentoring.hibernate.entity.Project;

@Stateless
public class ProjectDaoImpl implements ProjectDao {

	@PersistenceContext
	private EntityManager em;

	public void create(final Project entity) {
		em.persist(entity);
	}

	public Project findByID(final Integer id) {
		return em.find(Project.class, id);
	}

	public Project update(final Project entity) {
		return em.merge(entity);
	}

	public void delete(final Project entity) {
		em.remove(entity);
	}

	public List<Project> findAll() {
		final Query query = em.createQuery("from Project");
		return query.getResultList();
	}

}
