package com.cg.backend.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;
import com.cg.backend.entity.GuestUser;
import com.cg.backend.exception.GuestUserDoestNotExistsException;
import com.cg.backend.service.GuestUserService;
@ExcludedFromGeneratedCodeCoverage
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GuestUserController {

	@Autowired
	GuestUserService guestService;
	
	@PostMapping("/saveGuestUser/{guestUser}")
	public String temporaryUser(@PathVariable String guestUser) {
		
		return guestService.temporaryUser(guestUser);
		
	}
	
	@PostMapping("/saveGuest")
	public String saveGuestUser(@RequestBody GuestUser user) throws GuestUserDoestNotExistsException {
		
		
		return guestService.saveGuestUser(user);
		
	}
	
	@PostMapping("/searchUser/{email}")
	public GuestUser searchUser(@PathVariable String email) throws GuestUserDoestNotExistsException 
	{
		return guestService.searchUser(email);
	}
	
	@GetMapping("/getAllGuestUsers")
	public List<GuestUser> getAllGuestUsers() 
	{
		return guestService.getAllGuestUsers();
		
	}
}
