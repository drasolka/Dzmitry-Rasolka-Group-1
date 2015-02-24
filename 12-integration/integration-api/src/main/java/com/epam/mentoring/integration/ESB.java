package com.epam.mentoring.integration;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.epam.mentoring.ddd.dto.AbstractObject;

public class ESB {

	private static final Logger logger = Logger.getLogger(ESB.class);

	private static Socket socket;

	public static void main(final String[] args) {

		try {

			final int port = 25000;
			final int port2 = 25003;
			final ServerSocket serverSocket = new ServerSocket(port);
			logger.info("Server Started and listening to the port 25000");
			logger.info("esb start");

			while (true) {

				socket = serverSocket.accept();
				final InputStream is = socket.getInputStream();
				final ObjectInputStream ois = new ObjectInputStream(is);
				final AbstractObject to = (AbstractObject) ois.readObject();

				is.close();
				ois.close();

				if (to != null
						&& to.getEndpoint().equalsIgnoreCase("endpoint2")) {

					final String host = "localhost";
					final InetAddress address = InetAddress.getByName(host);
					final Socket socket = new Socket(address, port2);
					// Send the message to the server
					final OutputStream os = socket.getOutputStream();
					final ObjectOutputStream oos = new ObjectOutputStream(os);
					oos.writeObject(to);
					logger.info("sent message to 25003");
					oos.close();
					os.close();
					socket.close();
				} else {
					logger.info("message couldn't be sent: endpoint-"
							+ to.getEndpoint());
				}

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
