package com.cg.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.backend.annotations.ExcludedFromGeneratedCodeCoverage;
import com.cg.backend.entity.GuestUser;
@ExcludedFromGeneratedCodeCoverage
public interface GuestUserRepository extends JpaRepository<GuestUser,Integer>{
	
	 Optional<GuestUser> findByEmail(String email);
	 Boolean existsByEmail(String email);
	 
	 @Query(value="select * from guestuser_table where first_name = ?1",nativeQuery=true)
		public List<GuestUser> getByFirstName(String firstName);
}
