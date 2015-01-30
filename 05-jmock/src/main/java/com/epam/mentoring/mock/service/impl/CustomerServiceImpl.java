package com.epam.mentoring.mock.service.impl;

import java.util.List;

import com.epam.mentoring.mock.dao.CustomerDao;
import com.epam.mentoring.mock.model.Customer;
import com.epam.mentoring.mock.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(final CustomerDao customerDao) {
		this.customerDao = customerDao;
		final String msg = null;
		msg.toString();
	}

	public Customer getById(final String id) {
		return customerDao.getById(id);
	}

	public Customer getByEmail(final String email) {
		return customerDao.getByEmail(email);
	}

	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

}
