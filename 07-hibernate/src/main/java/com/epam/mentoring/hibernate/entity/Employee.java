package com.epam.mentoring.hibernate.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = -5405707555834313992L;

	private Integer id;

	private String name;

	private EmployeeStatus status;

	private Address address;

	private PersonalInfo personalInfo;

	private Unit unit;

	private Collection<Project> projects;

	public enum EmployeeStatus {
		FULL_TIME, PART_TIME
	}

	public Employee() {
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

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	public EmployeeStatus getStatus() {
		return status;
	}

	public void setStatus(final EmployeeStatus status) {
		this.status = status;
	}

	@Embedded
	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

	@OneToOne(mappedBy = "employee", cascade = CascadeType.PERSIST)
	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(final PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unit_id")
	public Unit getUnit() {
		return unit;
	}

	public void setUnit(final Unit unit) {
		this.unit = unit;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "employee_projects", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	public Collection<Project> getProjects() {
		return projects;
	}

	public void setProjects(final Collection<Project> projects) {
		this.projects = projects;
	}

}
