package org.cabbookingweb.repository;

import java.util.Optional;

import org.cabbookingweb.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer>{
	
	public Optional<Address> findByFromCityAndToCity(String Fromcity,String Tocity);

}
