package com.learn.controller;

import javax.imageio.spi.RegisterableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.Exception.EmailIdAlreadyExistsException;
import com.learn.Service.RegisterService;
import com.learn.model.User;



@RestController
public class RegisterController {
    
	@Autowired
	private RegisterService service;
	
	@PostMapping(path = "/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) throws EmailIdAlreadyExistsException
	{
		String message=service.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}
	
	@PostMapping(path = "/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<User> loginUser(@RequestBody User user) throws Exception
	{
		User loginUser=service.loginVerifyDetails(user);
		return ResponseEntity.ok(loginUser);
	}
}
