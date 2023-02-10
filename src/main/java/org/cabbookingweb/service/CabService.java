package org.cabbookingweb.service;

import java.util.List;

import org.cabbookingweb.entities.Cab;
import org.cabbookingweb.entities.Driver;
import org.springframework.stereotype.Service;

@Service
public interface CabService {
	
	public Cab addCab(Cab cab);

	public Cab updateCab(Cab cab);

	public Cab deleteCab(Integer cabId);
	
	public Cab findById(Integer cabId);

	public List<Cab> findBycabType(String cabType);
	
	public Integer countBycabType(String cabType);
	public List<Cab> findallcabs();
	public List<Cab> checkavailable();


}
