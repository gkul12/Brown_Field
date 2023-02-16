package com.cg.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;
import com.cg.backend.entity.Admin;
import com.cg.backend.entity.TicketDetails;
import com.cg.backend.service.AdminService;

@ExcludedFromGeneratedCodeCoverage
@CrossOrigin(origins =  "*")
@RestController
public class AdminController 
{
	@Autowired
	AdminService adminservice;
	
		@PostMapping("/getCustomerByFlightNumber")
		public List<TicketDetails> getCustomerByFlightNumber(@RequestBody Map<String, String> obj)
		{
			return adminservice.getCustomerByFlightNumber(obj.get("flightNumber"),obj.get("departureDate"));
		}
		
		@PostMapping("/registerAdmin")
		public ResponseEntity<String> registerAdmin(@RequestBody Admin admin)
		{
			return adminservice.registerAdmin(admin);
		}
}
