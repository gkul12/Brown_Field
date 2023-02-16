package com.cg.backend.exception;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;

@ExcludedFromGeneratedCodeCoverage
public class AeroplaneNotFoundException extends Exception
{
	public AeroplaneNotFoundException() {}
	
	public String toString()
	{
		return "Aeroplane does not exists";
	}

}
