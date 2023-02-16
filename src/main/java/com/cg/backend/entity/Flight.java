package com.cg.backend.entity;

import java.util.List;

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
public class Flight 
{
		
		@Id
		private int flightNumber;
		
		@OneToOne(cascade = CascadeType.ALL)
		private AirlineDetails airoplane;
		
		@Transient
		private String aId;
		private String source;
		private String destination;
		private String departureTime;
		private String arrivalTime;
		private int seats;
		private List<String> days;
		
		public Flight() {
			super();
		}

		public Flight(int flightNumber, AirlineDetails airoplane, String aId, String source, String destination,
				String departureTime, String arrivalTime, int seats, String status, List<String> days) {
			super();
			this.flightNumber = flightNumber;
			this.airoplane = airoplane;
			this.aId = aId;
			this.source = source;
			this.destination = destination;
			this.departureTime = departureTime;
			this.arrivalTime = arrivalTime;
			this.seats = seats;
			this.days = days;
		}

		public int getFlightNumber() {
			return flightNumber;
		}

		public void setFlightNumber(int flightNumber) {
			this.flightNumber = flightNumber;
		}

		public AirlineDetails getAiroplane() {
			return airoplane;
		}

		public void setAiroplane(AirlineDetails airoplane) {
			this.airoplane = airoplane;
		}

		public String getaId() {
			return aId;
		}

		public void setaId(String aId) {
			this.aId = aId;
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

		public int getSeats() {
			return seats;
		}

		public void setSeats(int seats) {
			this.seats = seats;
		}
		
		public List<String> getDays() {
			return days;
		}

		public void setDays(List<String> days) {
			this.days = days;
		}

		@Override
		public String toString() {
			return "Flight [flightNumber=" + flightNumber + ", airoplane=" + airoplane + ", aId=" + aId + ", source="
					+ source + ", destination=" + destination + ", departureTime=" + departureTime + ", arrivalTime="
					+ arrivalTime + ", seats=" + seats + ", days=" + days + "]";
		}

	}



