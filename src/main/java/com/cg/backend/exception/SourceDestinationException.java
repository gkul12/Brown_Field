package com.cg.backend.exception;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;

@ExcludedFromGeneratedCodeCoverage
public class SourceDestinationException extends Exception
{
	public SourceDestinationException() {}
	
	public String toString()
	{
		return "Source and Destination must be different";
	}
}
