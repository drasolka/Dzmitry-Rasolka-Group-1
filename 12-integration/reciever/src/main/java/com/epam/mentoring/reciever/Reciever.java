package com.epam.mentoring.reciever;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.epam.mentoring.ddd.dto.AbstractObject;

public class Reciever {

	private static final Logger logger = Logger.getLogger(Reciever.class);

	private static Socket socket;

	public static void main(final String[] args) {
		try {

			final int port = 25003;
			final ServerSocket serverSocket = new ServerSocket(port);
			logger.info("Server Started and listening to the port 25003");
			logger.info("reciever start");

			while (true) {

				socket = serverSocket.accept();
				final InputStream is = socket.getInputStream();
				final ObjectInputStream ois = new ObjectInputStream(is);
				final AbstractObject to = (AbstractObject) ois.readObject();

				logger.info("---------------recieved message: "
						+ to.getMessage());

				is.close();
				ois.close();

			}
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (final Exception e) {
			}
		}
	}

}
