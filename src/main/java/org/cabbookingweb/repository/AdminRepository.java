package org.cabbookingweb.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.cabbookingweb.entities.Admin;
import org.cabbookingweb.entities.Customer;
import org.cabbookingweb.entities.TripBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	@Query("from TripBooking where customer_id=:customerId order by fromDateTime desc")
	public List<TripBooking> findAllTrips(Integer customerId);
	
	
//	//@Query("from TripBooking where customer_id=:customerId")
//	public TripBooking findByTripBookingcustomer(Integer customerId);
//	
	public Admin findByuserName(String username);


	public Optional<Admin> findByUserNameAndPassword(String userName, String password);
	
	


	

}
