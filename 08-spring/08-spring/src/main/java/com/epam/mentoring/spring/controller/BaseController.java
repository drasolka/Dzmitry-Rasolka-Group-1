package com.epam.mentoring.spring.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.mentoring.spring.dto.PersonForm;
import com.epam.mentoring.spring.dto.ReserveForm;
import com.epam.mentoring.spring.entity.Person;
import com.epam.mentoring.spring.entity.Reservation;
import com.epam.mentoring.spring.entity.Session;
import com.epam.mentoring.spring.service.PersonService;
import com.epam.mentoring.spring.service.ReservationService;
import com.epam.mentoring.spring.service.SessionService;

@Controller
public class BaseController {

	private static final String VIEW_INDEX = "index";
	private static final String VIEW_RESERVE = "reserve";
	private static final String VIEW_RESERVE_FORM = "reserveForm";
	private static final String VIEW_PERSON_FORM = "personForm";
	private static final String VIEW_RESERVATION_LIST = "reservationList";

	@Resource
	PersonService personService;

	@Resource
	ReservationService reservationService;

	@Resource
	SessionService sessionService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getSession(final Model model) {

		model.addAttribute("sessions", sessionService.findAll());
		model.addAttribute("reservations", reservationService.findAll());
		model.addAttribute("persons", personService.findAll());

		return VIEW_INDEX;
	}

	@RequestMapping(value = "/reserve/{id}")
	public String getResevation(final Model model,
			@PathVariable("id") final Integer id) {
		model.addAttribute("sessionId", id);
		model.addAttribute("reserveForm", new ReserveForm());
		model.addAttribute("customers", personService.findAll());

		return VIEW_RESERVE_FORM;
	}

	@RequestMapping(value = "/reserve/addReservation/{id}", method = RequestMethod.POST)
	public String getResevation(final Model model,
			@PathVariable("id") final Integer id,
			final ReserveForm reserveForm, final BindingResult result) {

		final Session session = sessionService.findByID(id);

		final Reservation reservation = new Reservation();
		reservation.setDate(session.getDate());
		reservation.setFilmName(session.getFilmName());
		reservation.setPlace(reserveForm.getPlace());
		reservation.setPrice(session.getPrice());
		reservation.setCustomer(personService.findByID(reserveForm
				.getCustomerId()));

		reservationService.create(reservation);

		return "redirect:/";
	}

	@RequestMapping(value = "/addPerson", method = RequestMethod.GET)
	public String createPerson(final Model model) {
		model.addAttribute("personForm", new PersonForm());

		return VIEW_PERSON_FORM;
	}

	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	public String createPerson(final Model model, final PersonForm personForm,
			final BindingResult result) {

		final Person person = new Person();
		person.setFirstName(personForm.getFirstName());
		person.setLastName(personForm.getLastName());

		personService.create(person);

		return "redirect:/";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removeReservation(final Model model,
			@RequestParam(required = true) final Integer id) {

		final Reservation reservation = reservationService.findByID(id);
		reservationService.delete(reservation);
		model.addAttribute("reservations", reservationService.findAll());
		return VIEW_RESERVATION_LIST;
	}

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(final Model model) {

		// 1
		final Session session1 = new Session();
		session1.setPrice(50);
		final Calendar cal1 = new GregorianCalendar();
		cal1.set(2014, 12, 20, 19, 30);
		session1.setDate(cal1.getTime());
		session1.setFilmName("Titanic");

		// 2
		final Session session2 = new Session();
		session2.setPrice(70);
		final Calendar cal2 = new GregorianCalendar();
		cal2.set(2014, 12, 20, 21, 30);
		session2.setDate(cal2.getTime());
		session2.setFilmName("Avatar");

		sessionService.create(session1);
		sessionService.create(session2);

		final Person person = new Person();
		person.setFirstName("Alex");
		person.setLastName("Porto");

		personService.create(person);

		return "redirect:/";

	}
}