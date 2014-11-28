package com.epam.mentoring.jboss.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.epam.mentoring.jboss.dao.AccountDao;
import com.epam.mentoring.jboss.model.Account;
import com.epam.mentoring.jboss.model.Person;
import com.epam.mentoring.jboss.service.AccountService;

@Stateless
public class AccountServiceImpl implements AccountService {

	@EJB
	AccountDao accountDao;

	public List<Account> getAllAccount() {
		return accountDao.getAllAccount();
	}

	public void createAccount(final Person person, final String amount) {
		accountDao.createAccount(person, amount);
	}

}
