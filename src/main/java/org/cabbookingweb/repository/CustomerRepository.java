package org.cabbookingweb.repository;

import java.util.List;
import java.util.Optional;

import org.cabbookingweb.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	public Customer findByuserName(String userNmae);

	public Optional<Customer> findByUserNameAndPassword(String userName, String password);

}
