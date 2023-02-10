package org.cabbookingweb.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.cabbookingweb.entities.Address;
import org.cabbookingweb.entities.Cab;
import org.cabbookingweb.entities.Customer;
import org.cabbookingweb.entities.Driver;
import org.cabbookingweb.entities.TripBooking;
import org.cabbookingweb.repository.AddressRepository;
import org.cabbookingweb.repository.AdminRepository;
import org.cabbookingweb.service.AdminServiceImpl;
import org.cabbookingweb.service.CabService;
import org.cabbookingweb.service.CustomerServiceImpl;
import org.cabbookingweb.service.DriverService;
import org.cabbookingweb.service.TripBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@RequestMapping("/tripbooking")
@SessionAttributes({"customerId","driverId"})
@Scope("request")
public class TripBookingController {
	@Autowired
	private TripBookingService tripbookingservice;
	
	@Autowired
	private AdminServiceImpl adminservice;
	
	@Autowired
	private CustomerServiceImpl customerservice;
	
	@Autowired
	private AddressRepository addressrepository;
	
	@Autowired
	private DriverService driverservice;
	
	@Autowired
	private CabService cabservice;
	
	
	@GetMapping("/addtrip")
	public String addtrip(Model model)
	{
		TripBooking trip=new TripBooking();
		model.addAttribute("trip",trip);
		return "tripbooking/addtrip";
	}
	
	@PostMapping("/addtrip")
	public String processaddtrip(@ModelAttribute("trip")TripBooking trip)
	{
		TripBooking tr=tripbookingservice.addTripBooking(trip);
		if(tr==null)
			return "tripbooking/addunsuccess";
		else
			return "tripbooking/addsuccess";
		}
	
	//Modify
	
		@GetMapping("/modifytrips")
		public String modifytrip(Model model)
		{
			TripBooking trip=new TripBooking();
			model.addAttribute("trip",trip);
			return "tripbooking/modifytrip";
		}
		
		@PostMapping("/fetchtrip")
		public String fetchtrip(@ModelAttribute("trip") TripBooking trip,Model model)
		{
			 trip=tripbookingservice.findById(trip.getTripBookingId());
			if(trip!=null)
			{
				model.addAttribute("trip",trip);
				return "tripbooking/fetchsuccess";
			}
			else
			{
				
				return "tripbooking/fetchunsuccess";
			}
		}
		
		@PostMapping("/modifytrip")
		public String processmodifytrip(@ModelAttribute("trip")TripBooking trip,Model model)
		{
			TripBooking tr=tripbookingservice.updateTripBooking(trip);
			if(tr!=null)
				return "tripbooking/modifysuccess";
			else
				return "tripbooking/modifyunsuccess";
		}
		
		
		//Delete
		
		@GetMapping("/deletetrip")
		public String deletetrip(Model model)
		{
			TripBooking trip=new TripBooking();
			model.addAttribute("trip",trip);
			return "tripbooking/deletetrip";
		}
		
		@PostMapping("/fetchdeletetrip")
		public String fetchfordeletetrip(@ModelAttribute("trip") TripBooking trip,Model model)
		{
		    trip=tripbookingservice.findById(trip.getTripBookingId());
			if(trip!=null)
			{
				model.addAttribute("trip",trip);
				return "tripbooking/fetchdeletesuccess";
			}
			else
			{
				
				return "tripbooking/fetchunsuccess";
			}
		}

		
		@PostMapping("/deletetrip")
		public String processdeletetrip(@ModelAttribute("trip") TripBooking trip)
		{
			TripBooking tr=tripbookingservice.deleteTripBooking(trip.getTripBookingId());
			if(tr!=null)
				return "tripbooking/deletesuccess";
			else
				return "tripbooking/deleteunsuccess";
		}
		
		//findbyid
		
		@GetMapping("/findtrip")
		public String findtripbooking(Model model)
		{
			TripBooking trip=new TripBooking();
			model.addAttribute("trip",trip);
			return "tripbooking/findtrip";
		}
		
		@PostMapping("/fetchtripdetails")
		public String fetchtripdetails(@ModelAttribute("trip") TripBooking trip,Model model)
		{
			trip=tripbookingservice.findById(trip.getTripBookingId());
			if(trip!=null)
			{
				model.addAttribute("trip",trip);
				return "tripbooking/findsuccess";
			}
			else
			{
				
				return "tripbooking/fetchunsuccess";
			}
		}
		
		//findlistoftrips
//		@GetMapping("/tripsofcustomer")
//		public String findtrips(Model model)
//		{
//			Customer customer=new Customer();
//			model.addAttribute(customer);
//			return "tripbooking/tripsofcustomer";
//		}
		
//		@PostMapping("/viewalltrips")
//		public String viewtrips(@ModelAttribute("customer")Customer customer,Model model)
//		{
//			List<TripBooking> lists=tripbookingservice.findAllTrips(customer.getCustomerId());
//			if(lists.size()>0)
//			{
//				model.addAttribute("lists",lists);
//			    return "tripbooking/viewalltrips";
//			}
//			else
//				return "tripbooking/fetchunsuccess";
//		}
		
		//using session performing CRUD 
		
		@GetMapping("/viewalltrips")
		public String viewtrips(Model model)
		{
			Integer customerId= (Integer) model.getAttribute("customerId");
			//System.out.println(customerId);
			List<TripBooking> lists=adminservice.findAllTripsofcustomer(customerId);
			if(lists.size()>0)
			{
				model.addAttribute("trips",lists);
			    return "tripbooking/newtriplist";
			}
			else
				return "tripbooking/fetchunsuccess";
		}
		
		@GetMapping("/viewtrip")
		public String viewtrip(@org.springframework.web.bind.annotation.RequestParam("tripbookingId")Integer tripbookingId, Model model) {
			
			TripBooking tripss = tripbookingservice.findById(tripbookingId);
			model.addAttribute("tripss", tripss);
			return "tripbooking/viewtrips";
		}
		
		@GetMapping("/deltrip")
		public String deltrip(@org.springframework.web.bind.annotation.RequestParam("tripbookingId")Integer tripbookingId, Model model) {
			
			TripBooking tripss = tripbookingservice.findById(tripbookingId);
			model.addAttribute("tripss", tripss);
			return "tripbooking/viewdeltrips";
		}
		
		@PostMapping("/deltrip")
		public String fetchdeltrip(@ModelAttribute("tripss")TripBooking tripss,Model model)
		{
			TripBooking trips=tripbookingservice.findById(tripss.getTripBookingId());
			trips.setStatus(false);
    		tripbookingservice.updateTripBooking(trips);
    		Cab cab=cabservice.findById(trips.getCab().getCabId());
			Driver driver=cab.getDriver();
			cab.setAvailable(true);
			cabservice.updateCab(cab);
			driver.setAvailable(true);
			driverservice.updateDriver(driver);
    		return "tripbooking/tripcancel";
//			if(tr!=null)
//				return "tripbooking/deletesuccess";
//			else
//				return "tripbooking/deleteunsuccess";
		}
		
		//using session add trip
//		@GetMapping("/booktrip")
//		public String booktrip(Model model,Model model1)
//		{
//			TripBooking trip=new TripBooking();
//			model.addAttribute("trip",trip);
//			return "tripbooking/sessionadd";
//		}
		
//		@GetMapping("/booktripprocess")
//		public String booktripprocess(@ModelAttribute("trip")TripBooking trip ,Model model)
//		{
//			Integer customerId=(Integer) model.getAttribute("customerId");
//			//System.out.println(customerId);
//			Customer customer=customerservice.findById(customerId);
//			//System.out.println(customer);
//			trip.setCustomer(customer);
//			Optional<Address> address=addressrepository.findByFromCityAndToCity(trip.getFromLocation(), trip.getToLocation());
//			//System.out.println(address);
//			if(address.isPresent())
//			{
//				Driver driver=driverservice.checkavailable();
//				if(driver==null)
//					return "tripbooking/drivernotfound";
//				trip.setDriver(driver);
//				trip.setStatus(true);
//				Address addr=address.get();	
//				trip.setToDateTime(trip.getFromDateTime().plusMinutes(addr.getTime()));
//				Float price=driver.getCab().getPerKmRate();
//				trip.setDistanceInKm(addr.getDistance());
//				trip.setBill(price*trip.getDistanceInKm());
//				//trip.setToDateTime(null)
//				return "tripbooking/bookyourtrip";
//			}
//			else
//				return "tripbooking/locationnotfound";
//				
//		}
		//cablist
		@GetMapping("/getcabs")
		public String getCabs(Model model)
		{
			Integer customerId=(Integer) model.getAttribute("customerId");
			System.out.println(customerId);
			List<Cab> lists=cabservice.checkavailable();
			if(lists.size()>0)
			{
			model.addAttribute("cabs",lists);
			return "tripbooking/cablist";
			}
			else
				return"tripbooking/cabnotavailable";
		}
		//book
		@GetMapping("/booktrip")
		public String booktrip(@org.springframework.web.bind.annotation.RequestParam("cabId")Integer cabId,Model model)
		{
			TripBooking trip=new TripBooking();
			Integer customerId=(Integer) model.getAttribute("customerId");
			Customer customer=customerservice.findById(customerId);
			System.out.println(customerId);
			trip.setCustomer(customer);
			Cab cab=cabservice.findById(cabId);
			trip.setCab(cab);
			model.addAttribute("trip",trip);
			return "tripbooking/sessionadd";
		}
		
		@GetMapping("/booktrips")
		public String booktrips(@ModelAttribute("trip")TripBooking trip,Model model)
		{
			Optional<Address> address=addressrepository.findByFromCityAndToCity(trip.getFromLocation(), trip.getToLocation());
			if(address.isPresent())	
			{
				
				trip.setDriver(trip.getCab().getDriver());
				trip.setStatus(true);
				Address addr=address.get();
				trip.setToDateTime(trip.getFromDateTime().plusMinutes(addr.getTime()));
				Float price=trip.getCab().getPerKmRate();
				trip.setDistanceInKm(addr.getDistance());
				trip.setBill(price*trip.getDistanceInKm());
				return "tripbooking/bookyourtrip";
			}
			else
				return "tripbooking/locationnotfound";
			
		}
		
		@PostMapping("/booktrip")
		public String booktripfinal(@ModelAttribute("trip")TripBooking trip,Model model)
		{
			trip.setDate(LocalDate.now());
			TripBooking tr=tripbookingservice.addTripBooking(trip);
			if(tr!=null)
			{
				Cab cab=cabservice.findById(tr.getCab().getCabId());
				Driver driver=cabservice.findById(tr.getCab().getCabId()).getDriver();
				cab.setAvailable(false);
				cabservice.updateCab(cab);
				driver.setAvailable(false);
				driverservice.updateDriver(driver);
				return "tripbooking/addsuccess";
			}
			else
				return "tripbooking/addunsuccess";
		}
		
		
		//find all trips of driver
		@GetMapping("/viewdrivertrips")
		public String viewtripsdri(Model model)
		{
			Integer driverid=(Integer) model.getAttribute("driverId");
			List<TripBooking> lists=tripbookingservice.finddrivertrip(driverid);
			if(lists.size()>0)
			{
				model.addAttribute("trips",lists);
			    return "tripbooking/viewalldrivertrips";
			}
			else
				return "tripbooking/fetchunsuccessdriver";
		}
		
		@GetMapping("/viewtripdet")
		public String viewtripdriv(@org.springframework.web.bind.annotation.RequestParam("tripbookingId")Integer tripbookingId, Model model) {
			
			TripBooking tripss = tripbookingservice.findById(tripbookingId);
			model.addAttribute("tripss", tripss);
			return "tripbooking/viewtripsdriv";
		}
		
		
		
		
		
}
