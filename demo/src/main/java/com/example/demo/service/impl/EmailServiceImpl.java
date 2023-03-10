package com.example.demo.service.impl;

import com.example.demo.Utils.EmailDetails;
import com.example.demo.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl  implements EmailService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public String sendSimpleMail(EmailDetails details) {
		log.info(" >>> INSIDE EmailServiceImpl: sendSimpleMail");
		try {
			SimpleMailMessage mailMessage
					= new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsgBody());
			mailMessage.setSubject(details.getSubject());
			javaMailSender.send(mailMessage);
			log.info("Mail Sent Successfully...");
			return "Mail Sent Successfully...";
		}
		catch (Exception e) {
			log.error("Error while Sending Mail");
			throw e;
		}
	}
}
