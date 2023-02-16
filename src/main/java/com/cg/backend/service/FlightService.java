package com.cg.backend.service;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;
import com.cg.backend.entity.Airports;
import com.cg.backend.entity.Flight;
import com.cg.backend.exception.AeroplaneNotFoundException;
import com.cg.backend.repository.AirlineDao;
import com.cg.backend.repository.AirportRepository;
import com.cg.backend.repository.FlightRepository;


@Service
public class FlightService {

	@Autowired
	FlightRepository airplaneRepo;
	@Autowired
	AirportRepository airportRepo;
	@Autowired
	AirlineDao aDao;
	@Autowired
	ScheduledFlightsService fserv;
	
	
	public ResponseEntity<String> addFlight(Flight airplane) throws ParseException, AeroplaneNotFoundException 
	{
			
		if(airplane.getDestination().equals(airplane.getSource()))
		{
			
			return ResponseEntity
					.badRequest()
					.body("Error: Source and Destination must be different");
			
		}
	
		try
		{
			airplane.setAiroplane(aDao.findById(airplane.getaId()).get());
			airplaneRepo.save(airplane);
			fserv.scheduleFlightForYear(airplane);
			return new ResponseEntity<String>("Flight added", HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			throw new AeroplaneNotFoundException();
		}
		
	}

	public List<Flight> findAll() 
	{
		// TODO Auto-generated method stub
		return airplaneRepo.findAll();
	}

	public List<Airports> getAirports()
	{
		
		return airportRepo.findAll();
	}

	public Flight getFlightById(int id)
	{
			return airplaneRepo.findByFlightNumber(id);
	}

	public String updateFlight(Flight flight) 
	{	
		airplaneRepo.saveAndFlush(flight);
		return "Updated";
	}
	
	@ExcludedFromGeneratedCodeCoverage
	public List<String> getSource()
	{
		List<Flight> fList=airplaneRepo.findAll();
		List<String> source=new ArrayList<>();
		
		for(Flight f:fList)
		{
			if(!source.contains(f.getSource()))
			{
				source.add(f.getSource());
			}
		}
		
		return source;
	}
	
	@ExcludedFromGeneratedCodeCoverage
	public List<String> getDestination()
	{
		List<Flight> fList=airplaneRepo.findAll();
		List<String> destination=new ArrayList<>();
		
		for(Flight f:fList)
		{
			if(!destination.contains(f.getDestination()))
			{
				destination.add(f.getDestination());
			}
		}
		
		return destination;
	}
	public Flight searchFlight(int flightNumber) {
		return airplaneRepo.findByFlightNumber(flightNumber);
	}
	
	public ResponseEntity<String> deleteFlight(int flightNumber)
	{
		airplaneRepo.deleteById(flightNumber);
		return ResponseEntity.ok("Flight Deleted");
	}
}
