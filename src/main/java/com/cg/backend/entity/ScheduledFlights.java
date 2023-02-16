package com.cg.backend.entity;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@ExcludedFromGeneratedCodeCoverage
@Entity
public class ScheduledFlights 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int scheduledId;
	private String departureDate;
	private String status;
	private int numberOfSeats;
	private double fare;
	@ManyToOne
	Flight flight;
	
	public ScheduledFlights() {}

	public ScheduledFlights(int scheduledId, String departureDate, String status, int numberOfSeats, Flight flight, double fare) {
		super();
		this.scheduledId = scheduledId;
		this.departureDate = departureDate;
		this.status = status;
		this.numberOfSeats = numberOfSeats;
		this.flight = flight;
		this.fare=fare;
	}

	public int getScheduledId() {
		return scheduledId;
	}

	public void setScheduledId(int scheduledId) {
		this.scheduledId = scheduledId;
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

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "ScheduledFlights [scheduledId=" + scheduledId + ", departureDate=" + departureDate + ", status="
				+ status + ", numberOfSeats=" + numberOfSeats + ", fare=" + fare + ", flight=" + flight + "]";
	}

}
