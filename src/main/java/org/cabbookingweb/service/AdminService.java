package org.cabbookingweb.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.cabbookingweb.entities.Admin;
import org.cabbookingweb.entities.TripBooking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

	public Admin addAdmin(Admin admin);

	public Admin updateAdmin(Admin admin);

	public Admin deleteAdmin(Integer adminId);
	
	public Admin findAdminbyusername(String username);
	
	
	public List<TripBooking> findAllTripsofcustomer(Integer customerId);

	public List<TripBooking> findAllTripsDriverwise();

	public List<TripBooking> findAllTripsCustomerwise();

	public List<TripBooking> findAllTripsDatewise();
	public Admin findByuserName(String username);

	//public List<TripBooking> findAllTripsForDayes(Integer customerId, LocalDate fromDate, LocalDate toDate);

	public Admin findById(Integer adminId);
//	
//	public List<Admin> findAll();

	public Admin validateAdmin(String userName, String password);

	//public List<TripBooking> findAllTripsofcustomers(Integer customer_id);

}
