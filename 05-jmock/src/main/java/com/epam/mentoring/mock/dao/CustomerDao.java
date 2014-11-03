package com.epam.mentoring.mock.dao;

import java.util.List;

import com.epam.mentoring.mock.model.Customer;

public interface CustomerDao {

	Customer getById(String id);

	Customer getByEmail(String email);

	List<Customer> getAllCustomers();

}
