package com.myrecommended.business.emails;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;


@Component
public class EmailSender {
	private static final String SMTP_HOST_NAME = "localhost";
	private static final String SMTP_AUTH_USER = "info@latiendasustentable.com";
	private static final String SMTP_AUTH_PWD = "infolatienda123";
	private static final String emailFrom = "info@latiendasustentable.com";
	
	public void sendEMail(String recipient, String subject, String emailPath, String emailName, Map<String, String> values) throws MessagingException, AuthenticationFailedException { 
		String[] recipients = { recipient };
		this.sendEMail(recipients, subject, emailPath, emailName, values);
	}
	
	public void sendEMail(String recipients[], String subject, String emailPath, String emailName, Map<String, String> values) throws MessagingException, AuthenticationFailedException { 
		Message msg = this.getMessage(recipients, subject);
		String message = "";
		
		try {
			message = FileUtils.readFileToString(new File(emailPath + emailName + ".html"), Charset.defaultCharset());
			message = this.replaceValues(message, values);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		msg.setContent(message, "text/html");
		
		Transport.send(msg); 
	}
	
	private String replaceValues(String message, Map<String, String> values) {
		for(Entry<String, String> entry : values.entrySet()) {
			message = message.replace(entry.getKey(), entry.getValue());
		}
		
		return message;
	}

	private MimeMessage getMessage(String recipients[], String subject) throws MessagingException {
		boolean debug = false; 
		
		Properties props = new Properties(); 
		props.put("mail.smtp.host", SMTP_HOST_NAME); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.port", 26);
		Authenticator auth = new SMTPAuthenticator(); 
		Session session = Session.getDefaultInstance(props, auth); 
		session.setDebug(debug); 
		
		MimeMessage msg = new MimeMessage(session);
		
		InternetAddress addressFrom = new InternetAddress(emailFrom); 
		msg.setFrom(addressFrom); 
		InternetAddress[] addressTo = new InternetAddress[recipients.length]; 
		for (int i = 0; i < recipients.length; i++) { 
			addressTo[i] = new InternetAddress(recipients[i]); 
		} 
		
		msg.setRecipients(Message.RecipientType.TO, addressTo); 
		
		msg.setSubject(subject); 
		
		return msg; 
	}
	
	private class SMTPAuthenticator extends javax.mail.Authenticator { 
		public PasswordAuthentication getPasswordAuthentication() { 
			String username = SMTP_AUTH_USER; 
			String password = SMTP_AUTH_PWD; 
			return new PasswordAuthentication(username, password); 
		}
	}
}