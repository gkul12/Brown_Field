package com.cg.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.backend.entity.Admin;
import com.cg.backend.entity.TicketDetails;
import com.cg.backend.repository.AdminDao;
import com.cg.backend.repository.TicketDetailsRepository;
import com.cg.backend.repository.UserDao;



@Service
public class AdminService 
{

	@Autowired
	AdminDao admindao;
	@Autowired
	UserDao userdao;
	@Autowired 
	TicketDetailsRepository ticketRepo;

	public List<TicketDetails> getCustomerByFlightNumber(String flightNumber, String departureDate)
	{
		List<TicketDetails> tList=ticketRepo.findAll();
		List<TicketDetails> tickets=new ArrayList<>();
		int flightNum = Integer.parseInt(flightNumber);
		
		for(TicketDetails t:tList)
		{
			if(t.getFlight().getFlight().getFlightNumber()==flightNum && t.getFlight().getDepartureDate().equals(departureDate))
			{
				tickets.add(t);
			}
		}

		return tickets;
	}

	public ResponseEntity<String> registerAdmin(Admin admin) 
	{
		admindao.save(admin);
		return ResponseEntity.ok("Admin registered");
	}
}
