package org.cabbookingweb.service;

import java.time.LocalDate;


import java.util.List;
import java.util.Optional;

import org.cabbookingweb.entities.Admin;
import org.cabbookingweb.entities.Customer;
import org.cabbookingweb.entities.TripBooking;
import org.cabbookingweb.repository.AdminRepository;
import org.cabbookingweb.repository.CustomerRepository;
import org.cabbookingweb.repository.TripBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository repository;
	@Autowired
	private CustomerRepository customerrepo;
	
	@Autowired
	private TripBookingRepository triprepo;

	@Override
	public Admin addAdmin(Admin admin) {
		
//		Optional<Admin> opt = repository.findById(admin.getAdminId());
//		if(opt.isPresent()) {
//			return null;
//		}
		return repository.save(admin);
		
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		return repository.save(admin);
//		Optional<Admin> opt = repository.findById(admin.getAdminId());
//		if(opt.isPresent()) {
//			repository.save(opt.get());
//			return admin;
//		}
//		return null;
	}

	@Override
	public Admin deleteAdmin(Integer adminId) {
		Optional<Admin> opt = repository.findById(adminId);
		if(opt.isPresent()) {
			Admin admin = opt.get();
			repository.delete(admin);
			return admin;
		}
		return null;
	}

	
	@Override
	public List<TripBooking> findAllTripsDriverwise() {
		// TODO Auto-generated method stub
		List<TripBooking> list=triprepo.findByDriverAsc();
		return list;
	}

	@Override
	public List<TripBooking> findAllTripsCustomerwise() {

		List<TripBooking> list = triprepo.findtripscustomerwise();
		
			return list;

	}

	@Override
	public List<TripBooking> findAllTripsDatewise() {
	
		List<TripBooking> list = triprepo.findByFromdate_timeAsce();
		return list;
	}

//	@Override
//	public List<TripBooking> findAllTripsForDayes(Integer customerId, LocalDate fromDate, LocalDate toDate) {
//		
//		List<TripBooking> list =triprepo.findByCustomerIdAndFromdate_time(customerId,fromDate, toDate);
//		if(list.size() > 0)
//			return list;
//		return null;
//	}

//	@Override
//	public List<Admin> findAll() {
//		return repository.findAll();
//	}
//
	@Override
	public Admin findById(Integer adminId) {
		Optional<Admin> opt = repository.findById(adminId);
		if(opt.isPresent()) {
			Admin admin = opt.get();
			return admin;
		}
		return null;
	}
	@Override
	public List<TripBooking> findAllTripsofcustomer(Integer customer_id) {
		List<TripBooking> trips = repository.findAllTrips(customer_id);
				return trips;
				}


	@Override
	public Admin findAdminbyusername(String username) {
		// TODO Auto-generated method stub
		return repository.findByuserName(username);
	}

	@Override
	public Admin validateAdmin(String userName, String password) {
		List<Admin> c1  =repository.findAll();
		for(int i= 0; i < c1.size(); i++) {
			if(c1.get(i).getUserName().equals(userName) && c1.get(i).getPassword().equals(password))
			     return c1.get(i);
			}
		return null;
	}

	@Override
	public Admin findByuserName(String username) {
		return repository.findByuserName(username);
	}

}
