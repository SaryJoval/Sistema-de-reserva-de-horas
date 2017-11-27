package cl.accenture.curso_java.sistema_de_reserva.servicio;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public final class SendEmailUsingGMailSMTP {

	public static void envioMail(String email, String fecha) {

		// Recipient's email ID needs to be mentioned.
		String to = email;// change accordingly

		// Sender's email ID needs to be mentioned
		String from = "rhorasaccenture@gmail.com";// change accordingly
		final String username = "rhorasaccenture@gmail.com";// change accordingly
		final String password = "cursojava";// change accordingly

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new GMailAuthenticator(username, password));

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Reserva de Hora");

			// Now set the actual message
			message.setText("Hola has reservado una hora para el dia: " + fecha + " "
					+ "En los proximos dias te llamaremos para confirmar la reserva. Gracias");

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
