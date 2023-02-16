package com.cg.backend.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;
import com.cg.backend.entity.Airports;
import com.cg.backend.entity.Flight;
import com.cg.backend.exception.AeroplaneNotFoundException;
import com.cg.backend.service.FlightService;
@ExcludedFromGeneratedCodeCoverage
@RestController
@CrossOrigin(origins = "*")
public class FlightController {

	@Autowired
	FlightService fService;
	
	@PostMapping("/addFlight")
	ResponseEntity<String> addFlight(@RequestBody Flight airplane) throws ParseException, AeroplaneNotFoundException {
		return fService.addFlight(airplane);
	}	
	
	@GetMapping("/getAllFlights")
	public List<Flight> getAll()
	{
		return fService.findAll();
	}
	
	@GetMapping("/getSource")
	public List<String> getSource()
	{
		return fService.getSource();
	}
	
	@GetMapping("/getDestination")
	public List<String> getDestination()
	{
		return fService.getDestination();
	}
	
	@GetMapping("/getAllAirports")
	public List<Airports> getAirports()
	{
		return fService.getAirports();
	}
	
	@PostMapping("/updateFlight")
	public String updateFlight(@RequestBody Flight flight) {
		return fService.updateFlight(flight);
	}
	
	@PostMapping("/getFlightById")
	public Flight getFlightById(@RequestBody Map<String, Integer> id) 
	{	
		//System.out.println();
		return fService.getFlightById(id.get("flightNumber"));
	}
	
	@PostMapping("/searchFlight/{flightNumber}")
	public Flight searchFlight(@PathVariable int flightNumber) {
		
		return fService.searchFlight(flightNumber);
		
	}

	
}
