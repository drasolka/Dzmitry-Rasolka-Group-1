package com.epam.mentoring.hibernate.service;

import java.util.List;

import javax.ejb.Remote;

import com.epam.mentoring.hibernate.entity.Employee;

@Remote
public interface EmployeeService {

	public void create(Employee entity);

	Employee findByID(Integer id);

	Employee update(Employee entity);

	void delete(Employee entity);

	void assignEmployeeToProject(Integer empId, Integer projectId);

	void assignEmployeeToUnit(Integer empId, Integer unitId);

	List<Employee> findAll();
}
