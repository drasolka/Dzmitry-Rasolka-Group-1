package com.epam.mentoring.hibernate.dao;

import java.util.List;

import com.epam.mentoring.hibernate.entity.Employee;

public interface EmployeeDao extends GenericDao<Employee, Integer> {

	void assignEmployeeToProject(Integer empId, Integer projectId);

	void assignEmployeeToUnit(Integer empId, Integer unitId);

	List<Employee> findAll();
}
