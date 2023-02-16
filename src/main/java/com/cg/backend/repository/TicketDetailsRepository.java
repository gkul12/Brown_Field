package com.cg.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;
import com.cg.backend.dto.TicketDetailsDTO;
import com.cg.backend.entity.TicketDetails;
@ExcludedFromGeneratedCodeCoverage
@Repository
public interface TicketDetailsRepository extends JpaRepository<TicketDetails,Integer>{
	
	@Query(value = "select * from ticket_details where user_id = ?1", nativeQuery = true)
	public List<TicketDetails> getAllTicketsByUserId(int userId);
	
	@Query(value="select seat_number from ticket_details where flight_scheduled_id=?1",nativeQuery=true)
	public List<String> getSeatsForFlight(int scheduled_id);

	@Query(value="select first_name,last_name,gender,seat_number,status, id  from ticket_details where flight_scheduled_id=?1", nativeQuery=true)
	public List<List<Object>> getAllTicketsByScheduledId(int scheduleId);
	
	
	
}
