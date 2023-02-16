package com.cg.backend.dto;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;

@ExcludedFromGeneratedCodeCoverage
public class ScheduledFlightsDto 
{
	private int scheduled_id;
	private String departureDate;
	private double fare;
	private String arrivalTime;
	private String departureTime;
	private String destination;
	private String source;
	
	public ScheduledFlightsDto() {}

	public ScheduledFlightsDto(int scheduled_id, String departureDate, double fare, String arrivalTime,
			String departureTime, String destination, String source) {
		super();
		this.scheduled_id = scheduled_id;
		this.departureDate = departureDate;
		this.fare = fare;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.destination = destination;
		this.source = source;
	}

	public int getScheduled_id() {
		return scheduled_id;
	}

	public void setScheduled_id(int scheduled_id) {
		this.scheduled_id = scheduled_id;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "ScheduledFlightsDto [scheduled_id=" + scheduled_id + ", departureDate=" + departureDate + ", fare="
				+ fare + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ", destination="
				+ destination + ", source=" + source + "]";
	}

}
