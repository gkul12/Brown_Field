package com.cg.backend.exception;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;

@ExcludedFromGeneratedCodeCoverage
public class UserDoesNotExistsException extends Exception
{
	public UserDoesNotExistsException() {}
	
	public String toString()
	{
		return "User does not exists";
	}

}
