package com.epam.mentoring.hibernate.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.mentoring.hibernate.dao.EmployeeDao;
import com.epam.mentoring.hibernate.entity.Employee;
import com.epam.mentoring.hibernate.entity.Project;
import com.epam.mentoring.hibernate.entity.Unit;

@Stateless
public class EmpoyeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager em;

	public EmpoyeeDaoImpl() {

	}

	public void create(final Employee entity) {
		em.persist(entity);
	}

	public Employee findByID(final Integer id) {
		return em.find(Employee.class, id);
	}

	public Employee update(final Employee entity) {
		return em.merge(entity);
	}

	public void delete(final Employee entity) {
		em.remove(entity);
	}

	public void assignEmployeeToProject(final Integer empId,
			final Integer projectId) {
		final Project project = em.find(Project.class, projectId);
		final Employee employee = em.find(Employee.class, empId);
		project.getEmployees().add(employee);
		employee.getProjects().add(project);
	}

	public void assignEmployeeToUnit(final Integer empId, final Integer unitId) {
		final Unit unit = em.find(Unit.class, unitId);
		final Employee employee = em.find(Employee.class, empId);
		unit.getEmployees().add(employee);
		employee.setUnit(unit);
	}

	public List<Employee> findAll() {
		final Query query = em.createQuery("from Employee");
		return query.getResultList();
	}

}
