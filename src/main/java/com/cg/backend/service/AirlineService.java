package com.cg.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.backend.entity.AirlineDetails;
import com.cg.backend.exception.AeroplaneNotFoundException;
import com.cg.backend.repository.AirlineDao;

@Service
public class AirlineService {
	
	@Autowired
	AirlineDao adao;

	public List<AirlineDetails> getAll()
	{
		return adao.findAll();
	}
	
	public ResponseEntity<String> addAeroplaneDetails(AirlineDetails aeroplane)
	{
		adao.save(aeroplane);
		return ResponseEntity.ok("Aeroplane details added successfully!!");

	}

	public ResponseEntity<String> deleteAeroplane(String aeroplane_id) throws AeroplaneNotFoundException {
		try
		{
			adao.deleteById(aeroplane_id);
			return ResponseEntity.ok("Aeroplane deleted successfully!!");
		}
		catch(EmptyResultDataAccessException e)
		{
			throw new AeroplaneNotFoundException();
		}
	}

	
}
