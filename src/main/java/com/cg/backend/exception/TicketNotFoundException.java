package com.cg.backend.exception;

public class TicketNotFoundException extends Exception
{
	public TicketNotFoundException(){}
	
	public String toString()
	{
		return "Ticket not found";
	}

}
