package com.cg.backend.entity;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@ExcludedFromGeneratedCodeCoverage
@Entity

public class TicketDetails

{

	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String gender;
	
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ScheduledFlights flight;
	
	@Transient
	private int flightNum;
	private String seatNumber;
//	private int pnr;
	
	
	
	public TicketDetails() {
		super();
	}
	
	public TicketDetails(int id, String firstName, String lastName, String gender, String status,
			ScheduledFlights flight, int flightNum, String seatNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.status = status;
		this.flight = flight;
		this.flightNum = flightNum;
		this.seatNumber = seatNumber;
//		this.pnr = pnr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ScheduledFlights getFlight() {
		return flight;
	}
	public void setFlight(ScheduledFlights flight) {
		this.flight = flight;
	}
	public int getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
//	public int getPnr() {
//		return pnr;
//	}
//
//	public void setPnr(int pnr) {
//		this.pnr = pnr;
//	}

	@Override
	public String toString() {
		return "TicketDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", status=" + status + ", flight=" + flight + ", flightNum=" + flightNum + ", seatNumber="
				+ seatNumber + "]";
	}
	
	

}

 
