package tn.esprit.IRMCJEE.services;

import java.util.Date;
import java.util.Properties;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
@Stateless
public class EmailService implements EmailServiceLocal,EmailServiceRemote{
	@Resource(name = "java:/jboss/mail/gmail")
	private Session session;

	public EmailService() {

	}
	@Override
	public boolean sendEmail(String email) {
		String host = "smtp.gmail.com";
		String user = "irmc.pidev@gmail.com";
		String pass = "esprit2018";
		String to = email;
		String from = "irmc.pidev@gmail.com";
		String subject = "New Order";
		String url ="";
		String messageText = "You have a new order to deliver ! <br/> Consult our WebSite to see the order";
		boolean sessionDebug = false;
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.required", "true");

		// java.security.Security.addProvider(new
		// com.sun.net.ssl.internal.ssl.Provider());
		Session mailSession = Session.getDefaultInstance(props, null);
		mailSession.setDebug(sessionDebug);
		Message msg = new MimeMessage(mailSession);
		try {
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			// msg.setText(messageText);
			msg.setContent(messageText, "text/html; charset=utf-8");
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	}


