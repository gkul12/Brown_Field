package com.cg.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;
import com.cg.backend.dto.TicketDetailsDTO;
import com.cg.backend.entity.TicketDetails;
import com.cg.backend.exception.FlightDoesNotExistsException;
import com.cg.backend.exception.GuestUserDoestNotExistsException;
import com.cg.backend.exception.TicketNotFoundException;
import com.cg.backend.exception.UserDoesNotExistsException;
import com.cg.backend.repository.UserDao;
import com.cg.backend.service.TicketDetailsService;
@ExcludedFromGeneratedCodeCoverage
@RestController
@CrossOrigin(origins = "*")
public class TicketDetailsController 
{
	@Autowired
	TicketDetailsService tservice;
	@Autowired
	UserDao udao;
	
	@PostMapping("/getAllTickets/{emailId}/{flightNumber}")
	public List<TicketDetails> getAllTickets(@PathVariable String emailId,@PathVariable int flightNumber) throws UserDoesNotExistsException, GuestUserDoestNotExistsException
	{
		return tservice.getAllTickets(emailId,flightNumber);
	}
	
	@PostMapping("/addTickets/{emailId}")
	public ResponseEntity<String> AddTicket(@PathVariable String emailId, @RequestBody TicketDetails ticket) throws FlightDoesNotExistsException, UserDoesNotExistsException
	{
		return tservice.addTicket(ticket,emailId);
	}


	@PostMapping("/deleteTicket/{ticketId}/{emailId}")
	public ResponseEntity<String> deleteById(@PathVariable int ticketId,@PathVariable String emailId) throws UserDoesNotExistsException 
	{
		return tservice.deleteTicket(ticketId, emailId);
	
	}
	
	@PostMapping("/assignSeats/{seats}/{emailId}/{flightNumber}")
	public ResponseEntity<String> assignSeats(@PathVariable String seats,@PathVariable String emailId,@PathVariable int flightNumber) throws UserDoesNotExistsException, GuestUserDoestNotExistsException
	{
		return tservice.assignSeats(seats, emailId,flightNumber);
	}
	
	@PostMapping("/changingStatus/{status}/{customerId}")
	public ResponseEntity<String> changingStatus(@PathVariable String status, @PathVariable int customerId) throws TicketNotFoundException 
	{
		return tservice.changingStatus(status, customerId);
	
	}
	
	@GetMapping("/getBookings/{emailId}")
	public List<TicketDetails> getBookings(@PathVariable String emailId) throws UserDoesNotExistsException
	{
		return tservice.getBookings(emailId);
	}
	
	@PostMapping("/getSeatsForFlight/{scheduleId}")
	public List<String> getSeatsForFlight(@PathVariable int scheduleId)
	{
		return tservice.getSeatsForFlight(scheduleId);
	}
	
	@PostMapping("/getAllBookings/{scheduleId}")
	public List<TicketDetailsDTO> getAllBookings(@PathVariable int scheduleId){
		return tservice.getAllBookings(scheduleId);
	}
	
}
