package com.epam.mentoring.jboss.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.epam.mentoring.jboss.dao.AccountDao;
import com.epam.mentoring.jboss.model.Account;
import com.epam.mentoring.jboss.model.Person;

@Stateless
public class AccountDaoImpl implements AccountDao {

	public static final String QUERY_GET_PERSON_BY_PERSON = "name";
	public static final String QUERY_GET_ALL_ACCOUNT = "from Account";

	@PersistenceContext
	private EntityManager em;

	public List<Account> getAllAccount() {
		final Query query = em.createQuery(QUERY_GET_ALL_ACCOUNT);
		return query.getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createAccount(final Person person, final String amount) {
		final Account account = new Account(person, amount);
		em.persist(account);
	}

}
