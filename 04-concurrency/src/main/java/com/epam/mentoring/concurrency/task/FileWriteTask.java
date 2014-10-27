package com.epam.mentoring.concurrency.task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

public class FileWriteTask implements Runnable {

	private static final Logger logger = Logger.getLogger(FileWriteTask.class);

	private final String pathFile;

	private final BlockingQueue<String> queue;

	public FileWriteTask(final BlockingQueue<String> queue,
			final String pathFile) {
		this.queue = queue;
		this.pathFile = pathFile;
	}

	@Override
	public void run() {
		BufferedWriter wr = null;

		String line;
		try {
			wr = new BufferedWriter(new FileWriter(pathFile));
		} catch (final IOException e) {
			logger.info(e.getMessage());
		}

		while (true) {
			try {
				line = queue.take();
				wr.write(line + "\n");

			} catch (final InterruptedException e) {
				try {
					wr.close();
				} catch (final IOException e1) {
					logger.info(e.getMessage());
				}
				break;

			} catch (final IOException e) {
				logger.info(e.getMessage());
			}
		}

	}
}
