package com.epam.mentoring.concurrency.task;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

import com.epam.mentoring.concurrency.model.person.Person;

public class PopulatePersonModelTask implements Runnable {

	private static final Logger logger = Logger
			.getLogger(PopulatePersonModelTask.class);

	private final BlockingQueue<String> queue;
	private final List<Person> persons;

	public PopulatePersonModelTask(final BlockingQueue<String> queue,
			final List<Person> persons) {
		this.queue = queue;
		this.persons = persons;
	}

	@Override
	public void run() {
		String line;
		while (true) {
			try {

				line = queue.take();
				persons.add(new Person(line));

			} catch (final InterruptedException ex) {
				break;
			}
		}
	}
}
