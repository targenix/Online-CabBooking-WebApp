package org.cabbookingweb.repository;

import java.util.List;

import org.cabbookingweb.entities.Cab;
import org.cabbookingweb.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer>{
	
	
	//@Query("select distinct carType from Cab")
	public List<Cab> findBycarType(String cabType);
	
	public Integer countByCarType(String cabType);

	@Query("from Cab c where c.available=true")
	public List<Cab> findByAvailable();




}
