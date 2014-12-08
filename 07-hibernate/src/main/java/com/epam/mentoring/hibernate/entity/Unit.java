package com.epam.mentoring.hibernate.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Unit")
public class Unit implements Serializable {

	private static final long serialVersionUID = -9157270029310631418L;

	private Integer id;

	private String name;

	private Collection<Employee> employees;

	public Unit() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@OneToMany(targetEntity = Employee.class, mappedBy = "unit")
	public Collection<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(final Collection<Employee> employees) {
		this.employees = employees;
	}

}
