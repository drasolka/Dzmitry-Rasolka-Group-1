package com.epam.mentoring.jboss.web.person;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.mentoring.jboss.model.Person;
import com.epam.mentoring.jboss.service.PersonService;

@WebServlet(description = "Person Servlet", urlPatterns = { "/person",
		"/person.do" })
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	PersonService personService;

	@Override
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		final List<Person> persons = personService.getAllPerson();
		request.setAttribute("persons", persons);
		request.getRequestDispatcher("WEB-INF/jsp/person.jsp").forward(request,
				response);
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
