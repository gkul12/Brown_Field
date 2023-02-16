package com.cg.backend.dto;

import java.util.List;

public class TicketDetailsDTO {
	
	private int id;

	private String firstName;
	
	private String lastName;
	
	private String gender;
	
	private String status;
	
	private String seatNumber;
	
	

	public TicketDetailsDTO() {
		super();

	}
	
	public TicketDetailsDTO(List<Object> ticket) {
		this.id = (int) ticket.get(5);
		this.firstName = (String) ticket.get(0);
		this.lastName = (String) ticket.get(1);
		this.gender = (String) ticket.get(2);
		this.status = (String) ticket.get(4);
		this.seatNumber = (String) ticket.get(3);
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

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "TicketDetailsDTO [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", status=" + status + ", seatNumber=" + seatNumber + "]";
	}
	
	
	
}
