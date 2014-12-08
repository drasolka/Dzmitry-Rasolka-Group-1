package com.epam.mentoring.hibernate.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epam.mentoring.hibernate.dao.EmployeeDao;
import com.epam.mentoring.hibernate.entity.Employee;
import com.epam.mentoring.hibernate.service.EmployeeService;

@Stateless
public class EmployeeServiceImpl implements EmployeeService {

	@EJB
	EmployeeDao employeeDao;

	public EmployeeServiceImpl() {

	}

	public void create(final Employee entity) {
		employeeDao.create(entity);
	}

	public Employee findByID(final Integer id) {
		return employeeDao.findByID(id);
	}

	public Employee update(final Employee entity) {
		return employeeDao.update(entity);
	}

	public void delete(final Employee entity) {
		employeeDao.delete(entity);
	}

	public void assignEmployeeToProject(final Integer empId,
			final Integer projectId) {
		employeeDao.assignEmployeeToProject(empId, projectId);
	}

	public void assignEmployeeToUnit(final Integer empId, final Integer unitId) {
		employeeDao.assignEmployeeToUnit(empId, unitId);
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(final EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

}
