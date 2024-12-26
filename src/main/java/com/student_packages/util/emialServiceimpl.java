package com.student_packages.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class emialServiceimpl implements emailService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendSimpleEmail(String to, String sub, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(sub);
		message.setText(body);
		javaMailSender.send(message);
	}
	
	

}
