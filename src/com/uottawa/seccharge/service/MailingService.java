/*
 * @Author - Karan Thakker
 */

package com.uottawa.seccharge.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;

/*
 * This class should have actually been in the util repository, however since the util repository isn't present,
 * I've added it in the service package.
 * 
 * This class is basically used for sending an email to the user. It's called twice, 
i. for sending a confirmation email when booking is confirmed
ii. for sending the email using quartz scheduler reminding the user about the reservation slot booked.
 * 
 * 
 * It uses google smtp 
 */

public class MailingService {

	
		public void sendMail(String to, String subject, String body) {
		Properties props = new Properties();
		props.put("mail.smtp.user", "secchargetest");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.debug", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");
		props.setProperty("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallbac k", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		javax.mail.Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						
						/*
						 * Whatever email address the email is to be composed and sent to the user from, enter it here
						 * and message.setFrom
						 * 
						 */
						return new PasswordAuthentication(
								"secchargetest@gmail.com", "secproject");
					}
				});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("secchargetest@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress
					.parse(to));
			message.setSubject(subject);
			message.setText(body);
			message.setHeader("Content-Type" , "text/html" );
			Transport.send(message);
			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
}
