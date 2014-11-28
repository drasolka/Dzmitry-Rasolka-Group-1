package com.epam.mentoring.jboss.web.person;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.mentoring.jboss.service.PersonService;

@WebServlet(description = "Person Servlet", urlPatterns = { "/addPerson",
		"/addPerson.do" })
public class AddPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	PersonService personService;

	@Override
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		final String name = request.getParameter("name");
		personService.createPerson(name);
		request.getRequestDispatcher("/person").forward(request, response);
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
