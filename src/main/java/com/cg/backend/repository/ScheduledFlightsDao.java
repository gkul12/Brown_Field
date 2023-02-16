package com.cg.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;
import com.cg.backend.entity.ScheduledFlights;

import jakarta.transaction.Transactional;
@ExcludedFromGeneratedCodeCoverage
@Repository
public interface ScheduledFlightsDao extends JpaRepository<ScheduledFlights,Integer>
{
	@Query(value=" select scheduled_id,departure_date,fare,arrival_time,departure_time,destination,source from scheduled_flights fs inner join flight f on fs.flight_flight_number=f.flight_number and f.source=?1 and f.destination=?2 and fs.departure_date=?3",nativeQuery=true)
	public List<Object> findBySourceAndDestinationAndDepartureDate(String source,String destination,String departureDate);
	@Transactional
	@Modifying
	@Query(value="delete from scheduled_flights where departure_date < :date",nativeQuery=true)
	public void deletePastFlights(@Param("date")String date);
	
	@Query(value="select * from scheduled_flights where departure_date=?1",nativeQuery=true)
	public List<ScheduledFlights> findByDepartureDate(String date);
}
