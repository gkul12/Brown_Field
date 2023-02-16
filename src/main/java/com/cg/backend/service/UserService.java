package com.cg.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.backend.entity.Admin;
import com.cg.backend.entity.LoginRequest;
import com.cg.backend.entity.User;
import com.cg.backend.exception.AdminDoesNotExistsException;
import com.cg.backend.exception.UserDoesNotExistsException;
import com.cg.backend.repository.AdminDao;
import com.cg.backend.repository.UserDao;

@Service
public class UserService 
{
	@Autowired
	UserDao userdao;
	@Autowired
	AdminDao admindao;
//	 @Autowired
//	 JavaMailSender mailSender;
	
	public List<User> getUsers()
	{
		return userdao.findAll();
	}
	
	
	public ResponseEntity<String> registerUser(@RequestBody User user)
	{
		
		if (userdao.existsByEmail(user.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body("Error: Email is already in use!");
		}
		
		
		// Create new user's account
		User user1 = new User(user.getFisrtName(), user.getLastName(), user.getEmail(),
							  user.getPassword(),user.getGender(), 
							  user.getPhoneNumber(), user.getDob());
		userdao.save(user1);

		return ResponseEntity.ok("User registered successfully!");
		
		
	}
	
	
	public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) throws UserDoesNotExistsException, AdminDoesNotExistsException 
	{
		
		if (!loginRequest.isAdmin()) {
			if(!userdao.existsByEmail(loginRequest.getEmail()))
			{
				return ResponseEntity
						.badRequest()
						.body("Error: Email does not exists");
			}
			else
			{
				Optional<User> user=userdao.findByEmail(loginRequest.getEmail());
				if(!user.get().getPassword().equals(loginRequest.getPassword()))
					return ResponseEntity
							.badRequest()
							.body("Error: Wrong Credentials");
			}
		}
		else {

			if(!admindao.existsByEmail(loginRequest.getEmail()))
			{
				return ResponseEntity
						.badRequest()
						.body("Error: Email does not exists");
			}
			
			else
			{
				
				Optional<Admin> admin=admindao.findByEmail(loginRequest.getEmail());
				if(!admin.get().getPassword().equals(loginRequest.getPassword()))
					return ResponseEntity
							.badRequest()
							.body("Error: Wrong Credentials");

			}
		}
			
		return ResponseEntity.ok("Login Successful!");
		
	}

}
