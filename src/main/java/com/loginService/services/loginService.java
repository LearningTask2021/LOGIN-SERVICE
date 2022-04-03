package com.loginService.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginService.model.Users;
import com.loginService.repository.UsersRepository;
import com.loginService.services.loginService;

@Service
public class loginService {
	@Autowired
	private UsersRepository usersRepository;
	 Logger logger = LoggerFactory.getLogger(loginService.class);
	
	 public Users loginUser(String userId,String password) {
			Users user=usersRepository.findByUserIdAndPassword(userId,password).get();
			logger.info(user.toString());
			return user;
		}
}
