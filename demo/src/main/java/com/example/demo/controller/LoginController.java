package com.example.demo.controller;

import com.example.demo.Utils.EmailDetails;
import com.example.demo.entity.LoginEntity;
import com.example.demo.service.EmailService;
import com.example.demo.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {
	@Autowired
	private EmailService emailService;
	@Autowired
	private LoginService loginService;
	@PostMapping("/")
	public ResponseEntity<String> logIn(@RequestBody LoginEntity login){
		try{
			log.info(" >>> INSIDE LoginController: logIn");
			loginService.login(login);
			emailService.sendSimpleMail(new EmailDetails(login.getUserName(),"Login successful","Login successful",""));
			return ResponseEntity.ok("Login successful");
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login Failed");
		}
	}
}
