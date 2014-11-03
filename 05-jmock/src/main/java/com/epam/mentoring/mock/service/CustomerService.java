package com.epam.mentoring.mock.service;

import java.util.List;

import com.epam.mentoring.mock.model.Customer;

public interface CustomerService {

	Customer getById(String id);

	Customer getByEmail(String email);

	List<Customer> getAllCustomers();

}
