package com.epam.mentoring.jboss.web.account;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.mentoring.jboss.model.Account;
import com.epam.mentoring.jboss.service.AccountService;

@WebServlet(description = "Person Servlet", urlPatterns = { "/account",
		"/account.do" })
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AccountService accountService;

	@Override
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		final List<Account> accounts = accountService.getAllAccount();
		request.setAttribute("accounts", accounts);
		request.getRequestDispatcher("WEB-INF/jsp/account.jsp").forward(
				request, response);
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
