package org.cabbookingweb.service;

import java.util.List;
import java.util.Optional;

import org.cabbookingweb.entities.Customer;
import org.cabbookingweb.entities.Driver;
import org.cabbookingweb.entities.TripBooking;
import org.cabbookingweb.repository.DriverRepository;
import org.cabbookingweb.repository.TripBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripBookingServiceImpl implements TripBookingService {

	@Autowired
	private TripBookingRepository repository;
	
	@Autowired
	private DriverRepository driverrepository;

	@Override
	public TripBooking addTripBooking(TripBooking tripBooking) {
//		Optional<TripBooking> opt = repository.findById(tripBooking.getTripBookingId());
//		if (opt.isPresent()) {
//
//			return null;
//		}
//		repository.save(tripBooking);
		return repository.save(tripBooking);
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) {
		Optional<TripBooking> opt = repository.findById(tripBooking.getTripBookingId());
		if (opt.isPresent()){
			repository.save(tripBooking);
			return tripBooking;

		}
		return null;
	}

	@Override
	public TripBooking deleteTripBooking(Integer tripBookingId) {
		Optional<TripBooking> opt = repository.findById(tripBookingId);
		if (opt.isPresent()) {
			TripBooking tripBooking = opt.get();
			repository.delete(tripBooking);
			return tripBooking;

		}
		return null;
	}

	@Override
	public List<TripBooking> findAllTrips() {
		return repository.findAll();
	}

	@Override
	public TripBooking findById(Integer tripBookingId) {
		Optional<TripBooking> opt = repository.findById(tripBookingId);
		if (opt.isPresent()) {
			TripBooking trip = opt.get();
			return trip;
		}

		return null;
	}

	@Override
	public List<TripBooking> finddrivertrip(Integer driverid) {
		List<TripBooking> trips = repository.finddrivertrips(driverid);
		return trips;
		}
	

//	@Override
//	public TripBooking calculateBill(Integer customerId) {
//		return repository;
//	}

}
