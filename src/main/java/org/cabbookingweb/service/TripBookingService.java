package org.cabbookingweb.service;

import java.util.List;

import org.cabbookingweb.entities.TripBooking;



public interface TripBookingService {
	public TripBooking addTripBooking(TripBooking tripBooking);

	public TripBooking updateTripBooking(TripBooking tripBooking);

	public TripBooking deleteTripBooking(Integer tripBookingId);
	
	public TripBooking findById(Integer tripBookingId);

	public List<TripBooking> findAllTrips();
	
	public List<TripBooking> finddrivertrip(Integer driverid);

	//public TripBooking calculateBill(Integer customerId);
}
