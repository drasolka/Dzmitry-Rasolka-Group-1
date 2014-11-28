package com.epam.mentoring.jboss.web.account;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.mentoring.jboss.model.Person;
import com.epam.mentoring.jboss.service.AccountService;
import com.epam.mentoring.jboss.service.PersonService;

@WebServlet(description = "Account Servlet", urlPatterns = { "/addAccount",
		"/addAccount.do" })
public class AddAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	PersonService personService;

	@EJB
	AccountService accountService;

	@Override
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		final String name = request.getParameter("name");
		final String amount = request.getParameter("amount");

		final Person person = personService.getPersonByName(name);
		accountService.createAccount(person, amount);

		request.getRequestDispatcher("/account").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
	}
}
