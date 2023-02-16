package com.cg.backend.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.backend.entity.GuestUser;
import com.cg.backend.exception.GuestUserDoestNotExistsException;
import com.cg.backend.repository.GuestUserRepository;


@Service
public class GuestUserService 
{

	@Autowired
	GuestUserRepository guestrepo;

	public String temporaryUser(String guestUser) 
	{

		if(guestrepo.existsByEmail(guestUser))
		{
			return "Done";
		}

		GuestUser user = new GuestUser();
		guestrepo.save(user);
	
		return "Done";
	}
	
	public String saveGuestUser(GuestUser user) throws GuestUserDoestNotExistsException 
	{
		try
		{
			GuestUser u = guestrepo.findByEmail("GuestUser").get();
			
			u.setEmail(user.getEmail());
			u.setFirstName(user.getFirstName());
			u.setLastName(user.getLastName());
			u.setPhoneNumber(user.getPhoneNumber());
			
			guestrepo.saveAndFlush(u);
			
			return "saved";
		}
		catch(NoSuchElementException e)
		{
			throw new GuestUserDoestNotExistsException();
		}
	
	}
	
	public List<GuestUser> getAllGuestUsers() 
	{
		// TODO Auto-generated method stub
		return guestrepo.findAll();
	}
	
	public GuestUser searchUser(String email) throws GuestUserDoestNotExistsException 
	{
		try
		{
			return guestrepo.findByEmail(email).get();
		}
		catch(NoSuchElementException e)
		{
			throw new GuestUserDoestNotExistsException();
		}
	}
	
}
