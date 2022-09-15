package com.example.disney.servicios;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServicio {
	@Autowired
	JavaMailSender mailSender;
	
	public void sendEmail(String toEmail, String subject, String body) {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setSubject(subject);
			helper.setFrom("ejemplo@gmail.com");
			helper.setTo(toEmail);
			boolean html = true;
			helper.setText(body, html);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		mailSender.send(message);
		System.out.println("Mensaje enviado!");
		
	}
}
