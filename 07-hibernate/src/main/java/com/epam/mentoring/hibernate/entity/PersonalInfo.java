package com.epam.mentoring.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PersonalInfo")
public class PersonalInfo implements Serializable {

	private static final long serialVersionUID = 9034635913087562818L;

	private Integer id;

	private String characteristics;

	private Employee employee;

	public PersonalInfo() {
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

	@Column(name = "characteristics")
	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(final String characteristics) {
		this.characteristics = characteristics;
	}

	@OneToOne
	@JoinColumn(name = "employee_id")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(final Employee employee) {
		this.employee = employee;
	}
}
