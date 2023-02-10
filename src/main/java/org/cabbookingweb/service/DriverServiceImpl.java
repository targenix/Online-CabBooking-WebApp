package org.cabbookingweb.service;

import java.util.List;
import java.util.Optional;

import org.cabbookingweb.entities.Customer;
import org.cabbookingweb.entities.Driver;
import org.cabbookingweb.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@Component("driverService")
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository repository;

	@Override
	public Driver addDriver(Driver driver) {
		return repository.save(driver);
//		Optional<Driver> opt = repository.findById(driver.getDriverId());
//		if (opt.isPresent()) {
//			return null;
//		}
//		
//		return driver;
	}

	@Override
	public Driver updateDriver(Driver driver) {
		Optional<Driver> opt = repository.findById(driver.getDriverId());
		if (opt.isPresent()) {
			repository.save(driver);
			return driver;
		}
		
		return null;
	}

	@Override
	public Driver deleteDriver(Integer driverId) {
		Optional<Driver> opt = repository.findById(driverId);
		if (opt.isPresent()) {
			Driver driver = opt.get();
			repository.delete(driver);
			return driver;
		}
		
		return null;
	}

	@Override
	public List<Driver> getBestDrivers() {
		List<Driver> drivers= repository.findBestDriver();
		if(drivers.size()>0)
			return drivers;
		return null;
	}

	@Override
	public Driver findById(Integer driverId) {
		Optional<Driver> opt = repository.findById(driverId);
		if (opt.isPresent()) {
			Driver driver = opt.get();
			return driver;
		}

		return null;
	}
	
	@Override
	public Driver validateDriver(String username, String password) {
		List<Driver> c1  =repository.findAll();
		for(int i= 0; i < c1.size(); i++) {
			if(c1.get(i).getUserName().equals(username) && c1.get(i).getPassword().equals(password))
			     return c1.get(i);
			}
		return null;
	}

	@Override
	public Driver findDriverbyusername(String userName) {
		// TODO Auto-generated method stub
		return repository.findByuserName(userName);
	}

	@Override
	public List<Driver> findall() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Driver checkavailable() {
		// TODO Auto-generated method stub
		List<Driver> drivers=repository.findByAvailable();
		if(drivers.size()==0)
			return null;
		else
		{
			drivers.get(0).setAvailable(false);
			return repository.save(drivers.get(0));
		}
//			Float price=drivers.get(0).getCab().getPerKmRate();
//			return price;
//		}
	}

}
