package org.worldbuild.project.service;

import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.worldbuild.project.constant.Email;

public class EmailServiceImpl implements EmailService {
	private static final Logger LOGGER = Logger.getLogger(EmailServiceImpl.class);
	private final Session session ;
	
	public EmailServiceImpl(Session session){
		this.session=session;
	}
	
	@Override
	public boolean sendEnquiryEmail(HttpServletRequest request) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		StringBuilder sb= new StringBuilder("Hi, "+name);
		sb.append(System.lineSeparator());
		sb.append("You have sent an enqiry.");
		sb.append(System.lineSeparator());
		sb.append("Our team reach u soon");
		sb.append(System.lineSeparator());
		sb.append("Thank You !");
		sendAsyncEmail(email, "Event Enqiry", sb.toString());
		return true;
	}
	
	@Override
	public void sendAsyncEmail(String to, String suject, String content) {
		new Thread(()->sendEmail(to, suject, content)).start();;
	}
	
	@Override
	public void sendEmail(String to, String suject, String content) {
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(Email.EMAIL_FROM));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			msg.setSubject(suject);
			msg.setText(content);
			msg.setSentDate(new Date());
			Transport.send(msg);
			LOGGER.info("Email Sent..........");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
}
