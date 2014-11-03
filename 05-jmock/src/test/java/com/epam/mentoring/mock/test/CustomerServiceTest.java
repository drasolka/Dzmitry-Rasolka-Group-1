package com.epam.mentoring.mock.test;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.epam.mentoring.mock.dao.CustomerDao;
import com.epam.mentoring.mock.model.Customer;
import com.epam.mentoring.mock.service.impl.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

	public CustomerServiceImpl customerService;

	@Mock
	public CustomerDao customerDao;

	public Customer customer;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		customerService = new CustomerServiceImpl();
		customerService.setCustomerDao(customerDao);
		customer = new Customer("1", "test@test.tt", "John Smith");

	}

	@Test
	public void testGetById() {

		when(customerDao.getById("1")).thenReturn(customer);

		customerService.getById("1");

		verify(customerDao).getById("1");
	}

	@Test
	public void testGetByEmail() {

		when(customerDao.getByEmail("test@test.tt")).thenReturn(customer);

		customerService.getByEmail("test@test.tt");

		verify(customerDao).getByEmail("test@test.tt");
	}

	@Test
	public void testGetAllCustomers() {
		final List<Customer> customers = new ArrayList<Customer>();
		final Customer customer2 = new Customer("2", "test2@test.tt",
				"Mary Jane");
		customers.add(customer);
		customers.add(customer2);

		when(customerDao.getAllCustomers()).thenReturn(customers);

		customerService.getAllCustomers();

		verify(customerDao).getAllCustomers();
	}

}
