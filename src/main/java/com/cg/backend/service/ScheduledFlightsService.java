package com.cg.backend.service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;
import com.cg.backend.dto.FlightDto;
import com.cg.backend.entity.Flight;
import com.cg.backend.entity.ScheduledFlights;
import com.cg.backend.exception.FlightDoesNotExistsException;
import com.cg.backend.exception.NoScheduledFlightexception;
import com.cg.backend.repository.FlightRepository;
import com.cg.backend.repository.ScheduledFlightsDao;

@Service
public class ScheduledFlightsService 
{
	@Autowired
	FlightRepository fdao;
	@Autowired
	ScheduledFlightsDao fsdao;
	
	public static List<Date> getDatesforDayOfWeek(int year, int dayOfWeek) 
	{
		Date today=new Date();
	    List<Date> dateList = new ArrayList<>();
        Calendar newCal = Calendar.getInstance();
        newCal.set(Calendar.YEAR, year);
        newCal.set(Calendar.DAY_OF_YEAR, 1);
        
        // First, let's loop until we're at the correct day of the week.
        while (newCal.get(Calendar.DAY_OF_WEEK) != dayOfWeek) 
       {
            newCal.add(Calendar.DAY_OF_MONTH, 1);
        }
        // Now, add the Date to the List. Then add a week and loop (stop
        // when the year changes).
        do {
        	if(newCal.getTime().compareTo(today)>=0)
        	{
        		dateList.add(newCal.getTime());
        	}
            
            newCal.add(Calendar.DAY_OF_MONTH, 7);
        } while (newCal.get(Calendar.YEAR) == year);
	    
	    return dateList;
	}
	
	public void saveScheduledFlight(List<Date> dates,Flight f) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		
		for(Date date:dates)
		{
			ScheduledFlights sf=new ScheduledFlights();
			sf.setFlight(f);
			sf.setDepartureDate(df.format(date));
			sf.setNumberOfSeats(f.getSeats());
			Date date1 = format.parse(f.getArrivalTime());
			Date date2 = format.parse(f.getDepartureTime());
			
			long differenceInMilliSeconds= date2.getTime() - date1.getTime();
			long differenceInHours=(differenceInMilliSeconds/(1000*60*60))%24;
			double differenceInMinutes= (double)((differenceInMilliSeconds / (60 * 1000)) % 60)/60;
			double duration=differenceInHours+differenceInMinutes;
			
			if(duration>3)
			{
				sf.setFare(5000);
			}
			else if(duration>=2 && duration<3)
			{
				sf.setFare(4000);
			}
			else
			{
				sf.setFare(3000);
			}
			fsdao.save(sf);
		}
	}
	
	@ExcludedFromGeneratedCodeCoverage
	public void scheduleFlightForYear(Flight f) throws ParseException
	{	
		List<String> days=f.getDays();
		
		for(String day:days)
		{
			if(day.equals("Monday"))
		    {
				List<Date> mondays = getDatesforDayOfWeek(2023, Calendar.MONDAY);
				saveScheduledFlight(mondays,f);
		    	
		    }
		    else if(day.equals("Tuesday"))
		    {
		    	List<Date> tuesdays = getDatesforDayOfWeek(2023, Calendar.TUESDAY);
		    	saveScheduledFlight(tuesdays,f);
		    }
		    else if(day.equals("Wednesday"))
		    {
		    	List<Date> wednesdays = getDatesforDayOfWeek(2023, Calendar.WEDNESDAY);
		    	saveScheduledFlight(wednesdays,f);
				
		    }
		    else if(day.equals("Thursday"))
		    {
		    	List<Date> thursdays = getDatesforDayOfWeek(2023, Calendar.THURSDAY);
		    	saveScheduledFlight(thursdays,f);
		    	
		    }
		    else if(day.equals("Friday"))
		    {
		    	List<Date> fridays = getDatesforDayOfWeek(2023, Calendar.FRIDAY);
		    	saveScheduledFlight(fridays,f);
		    }
		    else if(day.equals("Saturday"))
		    {
		    	List<Date> saturdays = getDatesforDayOfWeek(2023, Calendar.SATURDAY);
		    	saveScheduledFlight(saturdays,f);
		    }
		    else if(day.equals("Sunday"))
		    {
		    	List<Date> sundays = getDatesforDayOfWeek(2023, Calendar.SUNDAY);
		    	saveScheduledFlight(sundays,f);	
		    }
		}
			
	}

	@ExcludedFromGeneratedCodeCoverage
	@Scheduled(cron="0 0 12 * * *")
	public void deletePastFlights()
	{
		System.out.println("Inside");
		Date today=new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		fsdao.deletePastFlights(df.format(today));
	}
	
	@ExcludedFromGeneratedCodeCoverage
	@Scheduled(cron="0 0 12 * * *")
	public void scheduleFlightsDaily() throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		System.out.println("Inside first");
		Calendar cal = Calendar.getInstance();  
		cal.add(Calendar.YEAR, 1);
		Date date=cal.getTime();
		DateFormat formatter = new SimpleDateFormat("EEEE");
		String day=formatter.format(date);
		List<Flight> flights=new ArrayList<>();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		if(day.equals("Monday"))
	    {
	    	flights=fdao.findFlightsForMonday();
	    	
	    }
	    else if(day.equals("Tuesday"))
	    {
	    	flights=fdao.findFlightsForTuesday();
	    	
	    }
	    else if(day.equals("Wednesday"))
	    {
	    	flights=fdao.findFlightsForWednesday();
	    	
	    }
	    else if(day.equals("Thursday"))
	    {
	    	flights=fdao.findFlightsForThursday();
	    	
	    }
	    else if(day.equals("Friday"))
	    {
	    	flights=fdao.findFlightsForFriday();
	    	
	    }
	    else if(day.equals("Saturday"))
	    {
	    	flights=fdao.findFlightsForSaturday();
	    	
	    }
	    else if(day.equals("Sunday"))
	    {
	    	flights=fdao.findFlightsForSunday();
	    	
	    }
		
		for(Flight f:flights)
    	{
			ScheduledFlights sf=new ScheduledFlights();
			sf.setFlight(f);
			sf.setDepartureDate(df.format(date));
			sf.setNumberOfSeats(f.getSeats());
			Date date1 = format.parse(f.getArrivalTime());
			Date date2 = format.parse(f.getDepartureTime());
			
			long differenceInMilliSeconds= date2.getTime() - date1.getTime();
			long differenceInHours=(differenceInMilliSeconds/(1000*60*60))%24;
			double differenceInMinutes= (double)((differenceInMilliSeconds / (60 * 1000)) % 60)/60;
			double duration=differenceInHours+differenceInMinutes;
			
			if(duration>3)
			{
				sf.setFare(5000);
			}
			else if(duration>=2 && duration<3)
			{
				sf.setFare(4000);
			}
			else
			{
				sf.setFare(3000);
			}
			fsdao.save(sf);

    	}
	}
	
	public List<Object> searchFlights(String source,String destination,String date) throws ParseException
	{
		List<Object> list=fsdao.findBySourceAndDestinationAndDepartureDate(source, destination, date);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		
		Date departDate = formatter.parse(date);
		long time_difference = departDate.getTime() - today.getTime();
		long days_difference = (time_difference / (1000*60*60*24)) % 365;

		
		if(days_difference<=5)
		{
			for (int i = 0; i < list.size(); i++) 
			{
				Object[] row = (Object[]) list.get(i);
				row[2]=Double.valueOf(row[2].toString())+2500;
			}
		}
		else if(days_difference>5 || days_difference<=15)
		{
			for (int i = 0; i < list.size(); i++) 
			{
				Object[] row = (Object[]) list.get(i);
				row[2]=Double.valueOf(row[2].toString())+1500;
			}
		}
		else if(days_difference>15 || days_difference<=25)
		{
			for (int i = 0; i < list.size(); i++) 
			{
				Object[] row = (Object[]) list.get(i);
				row[2]=Double.valueOf(row[2].toString())+1000;
			}
		}
		else if(days_difference>30)
		{
			for (int i = 0; i < list.size(); i++) 
			{
				Object[] row = (Object[]) list.get(i);
				row[2]=Double.valueOf(row[2].toString())-Double.valueOf(row[2].toString())*0.05;
			}
		}
		return list;
	}

	public int getNumofSeats(int scheduled_id) throws NoScheduledFlightexception 
	{
		try
		{
			return fsdao.findById(scheduled_id).get().getNumberOfSeats();
		}
		catch(NoSuchElementException e)
		{
			throw new NoScheduledFlightexception();
		}
	}

	public ScheduledFlights getScheduledFlightById(int scheduled_id) throws NoScheduledFlightexception 
	{
		try
		{
			return fsdao.findById(scheduled_id).get();
		}
		catch(NoSuchElementException e)
		{
			throw new NoScheduledFlightexception();
		}
	}
			
	public List<FlightDto> getTodayScheduledFlights()
	{
		Date today=new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return fsdao.findByDepartureDate(df.format(today)).stream().map(flight -> new FlightDto(flight)).toList();
	}
	
	public ResponseEntity<String> changeFlightStatus(String status,int flightId) throws FlightDoesNotExistsException, NoScheduledFlightexception
	{
		try
		{
			Optional<ScheduledFlights> flight = fsdao.findById(flightId);
			ScheduledFlights flightdata = flight.get();
			flightdata.setStatus(status);
			fsdao.save(flightdata);
			return ResponseEntity.ok(status);
		}
		catch(NoSuchElementException e)
		{
			throw new NoScheduledFlightexception();
		}
			
	}

	public List<ScheduledFlights> findAll() {
		// TODO Auto-generated method stub
		return fsdao.findAll();
	}
	
}
