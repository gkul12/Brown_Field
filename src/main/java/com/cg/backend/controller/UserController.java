package com.cg.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;
import com.cg.backend.entity.LoginRequest;
import com.cg.backend.entity.User;
import com.cg.backend.exception.AdminDoesNotExistsException;
import com.cg.backend.exception.UserDoesNotExistsException;
import com.cg.backend.repository.AdminDao;
import com.cg.backend.repository.UserDao;
import com.cg.backend.service.UserService;


/**
 * @author mlakhe
 *
 */
@ExcludedFromGeneratedCodeCoverage
@RestController
@CrossOrigin(origins =  "*")
public class UserController 
{
	@Autowired
	UserDao userdao;
	@Autowired
	AdminDao admindao;
	@Autowired
	UserService userservice;
	
	
	
	@GetMapping("/getallusers")
	public List<User> getUsers()
	{
		return userservice.getUsers();
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@RequestBody User user) 
	{

		return userservice.registerUser(user);
		
	}
	
	@PostMapping("/signin")
	public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) throws UserDoesNotExistsException, AdminDoesNotExistsException 
	{
		return userservice.loginUser(loginRequest);
	}
	
	@PostMapping("/searchLoggedUser/{email}")
	public User searchLoggedUser(@PathVariable String email) 
	{
		return userservice.searchLoggedUser(email);
	}
//	@PostMapping("/send")
//	@EventListener(ApplicationReadyEvent.class)
//	public void sendMail() {
//		userservice.sendSimpleEmail("mqwerty5899@gmail.com", "DEmo", "This is a demo");
//	}
	
}
