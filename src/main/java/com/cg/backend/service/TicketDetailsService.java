package com.cg.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.backend.dto.TicketDetailsDTO;
import com.cg.backend.entity.GuestUser;
import com.cg.backend.entity.TicketDetails;
import com.cg.backend.entity.User;
import com.cg.backend.exception.FlightDoesNotExistsException;
import com.cg.backend.exception.GuestUserDoestNotExistsException;
import com.cg.backend.exception.TicketNotFoundException;
import com.cg.backend.exception.UserDoesNotExistsException;
import com.cg.backend.repository.GuestUserRepository;
import com.cg.backend.repository.ScheduledFlightsDao;
import com.cg.backend.repository.TicketDetailsRepository;
import com.cg.backend.repository.UserDao;

@Service
public class TicketDetailsService 
{
	@Autowired
	TicketDetailsRepository trepo;
	@Autowired
	UserDao udao;
	@Autowired
	GuestUserRepository guestRepo;
	@Autowired
	ScheduledFlightsDao frepo;
	
	public List<TicketDetails> getAllTickets(String emailId,int flightNumber) throws UserDoesNotExistsException, GuestUserDoestNotExistsException
	{

		if(emailId.equals("GuestUser")) 
		{
			try
			{
				List<TicketDetails> tList= guestRepo.findByEmail(emailId).get().getTicketList();

				List<TicketDetails> ticketList=new ArrayList<>();
				for(TicketDetails t:tList)
				{
					if(t.getFlight().getScheduledId()==flightNumber)
					{
						//System.out.println
						ticketList.add(t);
					}
				}
		
				return ticketList;
			}
			catch(NoSuchElementException e)
			{
				throw new GuestUserDoestNotExistsException();
			}
			
		}
		try
		{
			List<TicketDetails> tList= udao.findByEmail(emailId).get().getTicketList();

			List<TicketDetails> ticketList=new ArrayList<>();
			for(TicketDetails t:tList)
			{
				if(t.getFlight().getScheduledId()==flightNumber)
				{
					//System.out.println
					ticketList.add(t);
				}
			}
	
			return ticketList;
		}
		catch(NoSuchElementException e)
		{
			throw new UserDoesNotExistsException();
		}

	}
	
	public ResponseEntity<String> addTicket(TicketDetails ticket,String emailId) throws FlightDoesNotExistsException, UserDoesNotExistsException
	{
		if(emailId.equals("GuestUser")) 
		{
			GuestUser user=guestRepo.findByEmail(emailId).get();
			List<TicketDetails> tList=user.getTicketList();
			try
			{
				ticket.setFlight(frepo.findById(ticket.getFlightNum()).get());
			}
			catch(NoSuchElementException e)
			{
				throw new FlightDoesNotExistsException();
			}
			tList.add(ticket);
			user.setTicketList(tList);
			guestRepo.save(user);

			return ResponseEntity.ok("Ticket Added");
		}
		try
		{
			User user=udao.findByEmail(emailId).get();
			List<TicketDetails> tList=user.getTicketList();
			try
			{
				ticket.setFlight(frepo.findById(ticket.getFlightNum()).get());
			}
			catch(NoSuchElementException e)
			{
				throw new FlightDoesNotExistsException();
			}
			tList.add(ticket);
			user.setTicketList(tList);
			udao.save(user);

			return ResponseEntity.ok("Ticket Added");
		}
		catch(NoSuchElementException e)
		{
			throw new UserDoesNotExistsException();
		}
	}
	
	
	public ResponseEntity<String> deleteTicket(int ticketId,String emailId) throws UserDoesNotExistsException 
	{
		if(emailId.equals("GuestUser")) {
			try
			{
				GuestUser user=guestRepo.findByEmail(emailId).get();
				List<TicketDetails> tList=user.getTicketList();

				for(TicketDetails t:tList)
				{
					if(t.getId()==ticketId)
					{
						tList.remove(t);
						break;
					}
				}
				
				user.setTicketList(tList);
				guestRepo.save(user);
				return ResponseEntity.ok("Ticket deleted..");
			}
			catch(NoSuchElementException e)
			{
				throw new UserDoesNotExistsException();
			}
		}
		try
		{
			User user=udao.findByEmail(emailId).get();
			List<TicketDetails> tList=user.getTicketList();

			for(TicketDetails t:tList)
			{
				if(t.getId()==ticketId)
				{
					tList.remove(t);
					break;
				}
			}
			
			user.setTicketList(tList);
			udao.save(user);
			return ResponseEntity.ok("Ticket deleted..");
		}
		catch(NoSuchElementException e)
		{
			throw new UserDoesNotExistsException();
		}
		
	}

	public ResponseEntity<String> changingStatus(String status, int ticketId) throws TicketNotFoundException {
		// TODO Auto-generated method stub
		try
		{
			TicketDetails temp = trepo.findById(ticketId).get();
			temp.setStatus(status);
			trepo.save(temp);
			return ResponseEntity.ok("Status Changed..");
		}
		catch(NoSuchElementException e)
		{
			throw new TicketNotFoundException();
		}
	}
	
	public ResponseEntity<String> assignSeats(String seats,String emailId,int flightNumber) throws UserDoesNotExistsException, GuestUserDoestNotExistsException 
	{
		String str[]=seats.split(",");
	
		List<TicketDetails> tList= getAllTickets(emailId,flightNumber);

		for(int i=0;i<tList.size();i++)
		{
			tList.get(i).setSeatNumber(str[i]);
			trepo.save(tList.get(i));
		}
		return ResponseEntity.ok("Seat number assigend");
	}
	
	public List<TicketDetails> myBookings(String emailId) throws UserDoesNotExistsException
	{
		try
		{
			return udao.findByEmail(emailId).get().getTicketList();	
		}
		catch(NoSuchElementException e)
		{
			throw new UserDoesNotExistsException();
		}
		
	}
	

	public List<TicketDetails> getBookings(String emailId) throws UserDoesNotExistsException
	{
		try
		{
			return udao.findByEmail(emailId).get().getTicketList();	
		}
		catch(NoSuchElementException e)
		{
			throw new UserDoesNotExistsException();
		}
		
	}
	
	public List<String> getSeatsForFlight(int scheduleId) 
	{
		List<String> seats = trepo.getSeatsForFlight(scheduleId);
		return seats;
	}

	public List<TicketDetailsDTO> getAllBookings(int scheduleId) {
		// TODO Auto-generated method stub
		List<List<Object>> resultlist = trepo.getAllTicketsByScheduledId(scheduleId);
		List<TicketDetailsDTO> d = resultlist.stream().map(l -> new TicketDetailsDTO(l)).collect(Collectors.toList());
		System.out.println(d);
		return d;
	}
}
