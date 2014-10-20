package com.epam.mentoring.management.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javassist.CannotCompileException;
import javassist.ClassPool;

import org.apache.log4j.Logger;

public class MemoryLeakClass {

	private static final Logger logger = Logger
			.getLogger(MemoryLeakClass.class);

	static {
		new OutOfMemoryError().printStackTrace();
	}

	public static void main(final String[] args) {

		final Scanner scanner = new Scanner(System.in);
		final int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			getHeapLeak();
		case 2:
			getPermgenLeak();
		default:
			System.exit(0);
		}

	}

	private static void getPermgenLeak() {
		for (int i = 0; i < 100000; i++) {
			try {
				generateClass("com.epam.memory.leak" + i);
			} catch (final Exception e) {
				logger.info(e.getMessage());
			}
		}
	}

	private static void getHeapLeak() {
		final List<Object> list = new ArrayList<Object>();
		while (true) {
			list.add(new Object());
		}
	}

	private static Class generateClass(final String name)
			throws CannotCompileException, RuntimeException {
		final ClassPool pool = ClassPool.getDefault();
		return pool.makeClass(name).toClass();
	}

}
