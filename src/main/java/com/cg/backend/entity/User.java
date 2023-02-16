package com.cg.backend.entity;

import java.util.List;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
@ExcludedFromGeneratedCodeCoverage
@Entity
@Table(	name = "user_table", 
uniqueConstraints = { 
	@UniqueConstraint(columnNames = "email") 
})

public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fisrtName;
	private String lastName;
	private String email;
	private String password;
	private String gender;
	private String phoneNumber;
	private String dob;
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name="user_id")
	private List<TicketDetails> ticketList;
	public User() {}
	

	public User(String fisrtName, String lastName, String email, String password, String gender,
			String phoneNumber, String dob) {
		
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getFisrtName() {
		return fisrtName;
	}


	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDob() {
		return dob;
	}
	public List<TicketDetails> getTicketList() {
		return ticketList;
	}


	public void setTicketList(List<TicketDetails> ticketList) {
		this.ticketList = ticketList;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public void setDate(String dob) {
		this.dob = dob;
	}
	
}
