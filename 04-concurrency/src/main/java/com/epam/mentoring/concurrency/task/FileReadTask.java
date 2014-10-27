package com.epam.mentoring.concurrency.task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class FileReadTask implements Runnable {

	private static final Logger logger = Logger.getLogger(FileReadTask.class);

	private final BlockingQueue<String> queue;

	private final String pathFile;

	public FileReadTask(final BlockingQueue<String> queue, final String path) {
		this.queue = queue;
		this.pathFile = path;

	}

	@Override
	public void run() {
		BufferedReader br = null;
		try {

			br = new BufferedReader(new FileReader(pathFile));
			String line;
			while ((line = br.readLine()) != null) {
				queue.offer(line, 365, TimeUnit.DAYS);
			}

		} catch (final FileNotFoundException e) {
			logger.info(e.getMessage());
		} catch (final IOException e) {
			logger.info(e.getMessage());
		} catch (final InterruptedException e) {
			logger.info(e.getMessage());
		} finally {
			try {
				br.close();
			} catch (final IOException e) {
				logger.info(e.getMessage());
			}
		}
	}
}
