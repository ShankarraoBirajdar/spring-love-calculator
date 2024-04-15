package com.shankar.lc.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class LCAppEmailServiceImpl implements LCAppEmailService {
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendMail(String userName, String userEmail, String result) {
		logger.info("Inside LCAppEmailServiceImpl->sendMail()");
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(userEmail);
		simpleMailMessage.setSubject("Love Calculator Apllication Result");
		simpleMailMessage.setText("Hi "+userName+" The Result predicted by the LCApp is "+ result);
		
		javaMailSender.send(simpleMailMessage);
		
	}

}
