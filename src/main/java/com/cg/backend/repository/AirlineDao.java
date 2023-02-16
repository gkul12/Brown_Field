package com.cg.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;
import com.cg.backend.entity.AirlineDetails;

@ExcludedFromGeneratedCodeCoverage
@Repository
public interface AirlineDao extends JpaRepository<AirlineDetails,String>{

//	@Query(value = "delete from aeroplanes where aeroplane_id = ?1", nativeQuery = true)
//	@Modifying
//	@Transactional
//	public void deleteByAeroplaneId(String aeroplane_id);


}
