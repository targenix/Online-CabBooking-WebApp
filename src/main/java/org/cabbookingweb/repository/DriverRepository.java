package org.cabbookingweb.repository;

import java.util.List;
import java.util.Optional;

import org.cabbookingweb.entities.Admin;
import org.cabbookingweb.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{


	@Query("from Driver d where d.rating>=4.5")
	public List<Driver> findBestDriver();
	
	public Driver findByuserName(String username);
	
	@Query("from Driver d where d.available=true")
	public List<Driver> findByAvailable();

	public Optional<Driver> findByUserNameAndPassword(String userName, String password);


}
