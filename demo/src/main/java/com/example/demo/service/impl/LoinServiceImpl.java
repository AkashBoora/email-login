package com.example.demo.service.impl;

import com.example.demo.Exception.LogInFailedException;
import com.example.demo.entity.LoginEntity;
import com.example.demo.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoinServiceImpl implements LoginService {
	@Override
	public void login(LoginEntity login) {
		log.info(" >>> INSIDE LoinServiceImpl: login");
		if(login.getUserName().endsWith("zemosolabs.com")){
			if(login.getPassword().matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")){
				log.info("Login Successful");
			}else{
				log.error("Password is incorrect");
				throw new LogInFailedException("Login failed");
			}
		} else{
			log.error("Incorrect mail id");
			throw new LogInFailedException("Login failed");
		}
	}
}
