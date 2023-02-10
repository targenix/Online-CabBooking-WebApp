package org.cabbookingweb.service;

import java.util.Optional;

import org.cabbookingweb.dto.LoginToken;
import org.cabbookingweb.entities.Admin;
import org.cabbookingweb.entities.Customer;
import org.cabbookingweb.entities.Driver;
import org.cabbookingweb.repository.AdminRepository;
import org.cabbookingweb.repository.CustomerRepository;
import org.cabbookingweb.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl {
	
	@Autowired
	private CustomerRepository customerrepository;
	
	
	@Autowired
	private AdminRepository adminrepository;
	
	@Autowired
	private DriverRepository driverrepository; 
	
	public Customer checklogin(LoginToken logintoken)
	{
		Optional<Customer> customeropt=customerrepository.findByUserNameAndPassword(logintoken.getUserName(),logintoken.getPassword());
		if(customeropt.isPresent())
			return customeropt.get();
		else
			return null;
	}
	
	public Admin checkloginadmin(LoginToken logintoken)
	{
		Optional<Admin> adminopt=adminrepository.findByUserNameAndPassword(logintoken.getUserName(),logintoken.getPassword());
		if(adminopt.isPresent())
			return adminopt.get();
		else
			return null;
	}

	public Driver checklogindriver(LoginToken logintoken) {
		// TODO Auto-generated method stub
		Optional<Driver> driveropt=driverrepository.findByUserNameAndPassword(logintoken.getUserName(),logintoken.getPassword());
		if(driveropt.isPresent())
			return driveropt.get();
		else
			return null;
	}
	
	
}
