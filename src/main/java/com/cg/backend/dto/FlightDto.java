package com.cg.backend.dto;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;
import com.cg.backend.entity.ScheduledFlights;
@ExcludedFromGeneratedCodeCoverage
public class FlightDto {

	private int scheduled_id;
	private String departureDate;
	private String status = "On-Time";
	private int numberOfSeats;
	private double fare;
	private String source;
	private String destination;
	private String departureTime;
	private String arrivalTime;
	
	public FlightDto(ScheduledFlights flight) 
	{
		// TODO Auto-generated constructor stub
		this.scheduled_id=flight.getScheduledId();
		this.departureDate=flight.getDepartureDate();
		this.status=flight.getStatus();
		this.numberOfSeats=flight.getNumberOfSeats();
		this.fare=flight.getFare();
		this.source=flight.getFlight().getSource();
		this.destination=flight.getFlight().getDestination();
		this.arrivalTime=flight.getFlight().getArrivalTime();
		this.departureTime=flight.getFlight().getDepartureTime();
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getScheduled_id() {
		return scheduled_id;
	}

	public void setScheduled_id(int scheduled_id) {
		this.scheduled_id = scheduled_id;
	}

	@Override
	public String toString() {
		return "FlightDto [departureDate=" + departureDate + ", status=" + status + ", numberOfSeats=" + numberOfSeats
				+ ", fare=" + fare + ", source=" + source + ", destination=" + destination + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + "]";
	}
	
}
