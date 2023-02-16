package com.cg.backend.exception;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;

@ExcludedFromGeneratedCodeCoverage
public class FlightDoesNotExistsException extends Exception
{
	public FlightDoesNotExistsException() {}
	
	public String toString()
	{
		return "No Flight exists for given flight number";
	}
}
