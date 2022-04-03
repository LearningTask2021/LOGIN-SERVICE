package com.loginService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loginService.model.Users;
import com.loginService.services.loginService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1.0/tweets")
public class loginController {
	
	@Autowired
    loginService loginService;
    Logger logger = LoggerFactory.getLogger(loginController.class);
   
    
    @GetMapping("/check")
    public String welcome() {
    	return "Hello!";
    }
    
   
  //login a registered user  
    @GetMapping("/login")
    public ResponseEntity loginUser(@RequestParam String userId,@RequestParam String password){
    	try {
    		
    		Users newUser=loginService.loginUser(userId,password);
    		//System.out.println(newUser);
    		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        	}
        	catch(Exception e) {
        		
                return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        	}
    }
}
