package org.worldbuild.project.beans;

import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.worldbuild.project.constant.Email;
import org.worldbuild.project.modal.NotificationSseModal;
import org.worldbuild.project.service.EmailService;
import org.worldbuild.project.service.EmailServiceImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ApplicationBeanContext {
	
	public static Gson gson;
	public static Session session ;
	public static EmailService emailService;
	public static LinkedBlockingQueue<NotificationSseModal> blockingQueue;
	public static ScheduledExecutorService scheduledExecutorService;

	static {
		gson= new GsonBuilder().create();
		blockingQueue= new LinkedBlockingQueue<>();
		scheduledExecutorService= Executors.newScheduledThreadPool(8);
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", Email.SMTP_SERVER); // optional, defined in SMTPTransport
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "587"); // default port 25 // SSL Port 465
		prop.put("mail.smtp.starttls.enable", "true"); //TLS
		prop.put("mail.smtp.user", Email.USERNAME);
		prop.put("mail.smtp.password", Email.PASSWORD);
		session=Session.getInstance(prop,  new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(Email.USERNAME, Email.PASSWORD);
	        }
	    });
		emailService = new EmailServiceImpl(session);
		
		
	}

	private ApplicationBeanContext() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Gson getGson() {
		return gson;
	}
	
	public static Session getSession() {
		return session;
	}

	public static EmailService getEmailService() {
		return emailService;
	}

	public static LinkedBlockingQueue<NotificationSseModal> getBlockingQueue() {
		return blockingQueue;
	}

	public static ScheduledExecutorService getScheduledExecutorService() {
		return scheduledExecutorService;
	}

	

}
