package org.cabbookingweb.service;

import java.util.List;

import org.cabbookingweb.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer deleteCustomer(Integer customerId);

	public Customer findById(Integer customerId);
	public Customer findcustomerbyusername(String username);

	public List<Customer> findAll();

	public Customer validateCustomer(String username, String password);

}
