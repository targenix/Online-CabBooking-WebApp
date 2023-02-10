package org.cabbookingweb.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.cabbookingweb.entities.TripBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking, Integer>{
	

	@Query("from TripBooking order by customer_id")
	public List<TripBooking> findtripscustomerwise();
	@Query("from TripBooking  order by fromDateTime")
	public List<TripBooking> findByFromdate_timeAsce();
	
	//@Query("from TripBooking where customerId=:customerId AND1 fromDateTime=date AND toDateTime=toDate")
	//public List<TripBooking> findByCustomerIdAndFromdate_time(Integer customerId, LocalDate date,LocalDate toDate);
	
	@Query("from TripBooking  ORDER by driver_id")
	public List<TripBooking> findByDriverAsc();
	
	@Query("from TripBooking where driver_id=:driverid order by fromDateTime desc")
	 public List<TripBooking> finddrivertrips(Integer driverid);
}
