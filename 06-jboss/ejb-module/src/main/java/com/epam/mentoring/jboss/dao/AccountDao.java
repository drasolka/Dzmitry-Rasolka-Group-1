package com.epam.mentoring.jboss.dao;

import java.util.List;

import javax.ejb.Local;

import com.epam.mentoring.jboss.model.Account;
import com.epam.mentoring.jboss.model.Person;

@Local
public interface AccountDao {

	List<Account> getAllAccount();

	void createAccount(Person person, String amount);
}
