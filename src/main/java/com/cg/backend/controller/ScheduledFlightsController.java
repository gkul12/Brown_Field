package com.cg.backend.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;
import com.cg.backend.dto.FlightDto;
import com.cg.backend.entity.ScheduledFlights;
import com.cg.backend.exception.FlightDoesNotExistsException;
import com.cg.backend.exception.InvalidDepartureDateException;
import com.cg.backend.exception.NoScheduledFlightexception;
import com.cg.backend.exception.SourceDestinationException;
import com.cg.backend.service.ScheduledFlightsService;
@ExcludedFromGeneratedCodeCoverage
@RestController
public class ScheduledFlightsController 
{
	@Autowired
	ScheduledFlightsService fservice;
	
	
	@GetMapping("/searchFlight")
	public List<Object> serachFlight(@RequestParam(value = "source") String source,@RequestParam(value = "destination") String destination,@RequestParam(value = "departureDate") String departureDate) throws ParseException, SourceDestinationException, InvalidDepartureDateException
	{
		
		return fservice.searchFlights(source, destination, departureDate);

	}
	
	@PostMapping("/getNumofSeats/{scheduled_id}")
	public int getNumofSeats(@PathVariable int scheduled_id) throws NoScheduledFlightexception
	{
		return fservice.getNumofSeats(scheduled_id);
		
	}
	
	@PostMapping("/getScheduledFlight/{scheduled_id}")
	public ScheduledFlights getScheduledFlightById(@PathVariable int scheduled_id) throws NoScheduledFlightexception {
		
		return fservice.getScheduledFlightById(scheduled_id);
	}
	
	@GetMapping("/getTodayScheduledFlights")
	public List<FlightDto> getTodayScheduledFlights()
	{
		return fservice.getTodayScheduledFlights();
	}
	
	@PostMapping("/changeFlightStatus/{status}/{flightId}")
	public ResponseEntity<String> changeFlightStatus(@PathVariable String status,@PathVariable int flightId) throws FlightDoesNotExistsException, NoScheduledFlightexception
	{
			return fservice.changeFlightStatus(status,flightId);
	}
	
	@GetMapping("/getAllScheduledFlights")
	public List<ScheduledFlights> getAll()
	{
		return fservice.findAll();
	}
	
}
