package org.cabbookingweb.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.cabbookingweb.entities.Admin;
import org.cabbookingweb.entities.Cab;
import org.cabbookingweb.entities.Customer;
import org.cabbookingweb.entities.Driver;
import org.cabbookingweb.entities.TripBooking;
import org.cabbookingweb.service.CabService;
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
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/driver")
@SessionAttributes("driverId")
@Scope("request")
public class DriverController {
	
	@Autowired
	private DriverService driverservice;
	
	@Autowired
	private TripBookingService tripbookingservice;
	
	@Autowired
	private CabService cabservice;
	
	@GetMapping("/adddriver")
	public String addadmin(Model model)
	{
		Driver driver=new Driver();
		model.addAttribute("driver",driver);
		return "driver/adddriver";
	}
	
	@PostMapping("/adddriver")
	public String processadddriver(@ModelAttribute("driver")Driver driver)
	{
		if(driverservice.findDriverbyusername(driver.getUserName())==null)
		{
		    driver.setAvailable(true);
			List<Cab> list=cabservice.findallcabs();
			for(Cab cab:list)
			{
				if(cab.getCabId()==driver.getCab().getCabId())
					cab.setDriver(driver);
			}
			
			//System.out.println(driver.getCab().getCabId());
		driverservice.addDriver(driver);
			return "driver/addsuccess";
		}
		
			return "driver/addunsuccess";
		}
	
	//modifydriver
	
	@GetMapping("/modifydriver")
	public String modifycab(Model model)
	{
		Driver driver=new Driver();
		model.addAttribute(driver);
		return "driver/modifydriver";
	}
	
	@PostMapping("/fetchdriver")
	public String fetchadmin(@ModelAttribute("driver") Driver driver,Model model)
	{
		 driver=driverservice.findById(driver.getDriverId());
		if(driver!=null)
		{
			model.addAttribute("driver",driver);
			return "driver/fetchsuccess";
		}
		else
		{
			
			return "driver/fetchunsuccess";
		}
	}
	
	@PostMapping("/modifydriver")
	public String processmodifydriver(@ModelAttribute("driver")Driver driver)
	{
		Driver d=driverservice.updateDriver(driver);
		if(d!=null)
			return "driver/modifysuccess";
		else
			return "driver/modifyunsuccess";
	}
	
	//deletedriver
	
	@GetMapping("/deletedriver")
	public String deletecab(Model model)
	{
		Driver driver=new Driver();
		model.addAttribute(driver);
		return "driver/deletedriver";
	}
	
	@PostMapping("/fetchdeletedriver")
	public String fetchfordeletedriver(@ModelAttribute("driver")Driver driver,Model model)
	{
	    driver=driverservice.findById(driver.getDriverId());
	    if(driver!=null)
		{
			model.addAttribute("driver",driver);
			return "driver/fetchdeletesuccess";
		}
		else
		{
			
			return "driver/fetchunsuccessdriver";
		}
	}
	
	@PostMapping("/deletedriver")
	public String processdeletedriver(@ModelAttribute("driver")Driver driver)
	{
		Driver d=driverservice.deleteDriver(driver.getDriverId());
		if(d!=null)
			return "driver/deletesuccess";
		else
			return "driver/deleteunsuccess";
	}
	
	//fetchdriverrecord
	
	
	@GetMapping("/finddriver")
	public String finddriver(Model model)
	{
		Driver driver=new Driver();
		model.addAttribute(driver);
		return "driver/finddriver";
	}
	
	@PostMapping("/fetchdriverdetails")
	public String fetchdriverdetails(@ModelAttribute("driver") Driver driver,Model model)
	{
		driver=driverservice.findById(driver.getDriverId());
		if(driver!=null)
		{
			model.addAttribute("driver",driver);
			return "driver/findsuccess";
		}
		else
		{
			
			return "driver/fetchunsuccess";
		}
	}
	
	//getbestdrivers
	
	@GetMapping("/viewbestdrivers")
	public String viewbestdrivers(Model model)
	{
		List<Driver> list=driverservice.getBestDrivers();
		if(list!=null)
		{
			model.addAttribute("list",list);
			return "driver/bestdriverslist";
		}
		else
			return "driver/fetchunsuccess";
	}
	
	//getbestdriversforadmin
	
	@GetMapping("/findbestdrivers")
	public String findbestdrivers(Model model)
	{
		List<Driver> list=driverservice.getBestDrivers();
		if(list!=null)
		{
			model.addAttribute("list",list);
			return "driver/bestdriverslistadmin";
		}
		else
			return "driver/fetchunsuccessadmin";
	}
	
	

	
	//validate driver
	@GetMapping("/login")
	public String logindriver(Model model)
	{
		Driver driver=new Driver("","");
		model.addAttribute("driver",driver);
		return "driver/logindriver"; 
		
	}
	
	@PostMapping("/validdriver")
	public String validdriver(@ModelAttribute("driver") Driver driver,Model model)
	{
		if(driverservice.validateDriver(driver.getUserName(),driver.getPassword())!=null)
			return "driver/profile"; //here add welcome $name then logged in
		else
			return "driver/profilenotfound";
	}
	@GetMapping("/findalldrivers")
	public String listDrivers(Model model)
	{
		List<Driver> lists=driverservice.findall();
		model.addAttribute("lists",lists);
		if(lists.size()>0)
		return "driver/listdrivers";
		else
			return "driver/fetchunsuccess";
	}

	//using session edit
	
	@GetMapping("/editdriverdetails")
	public String updateadm( Model model) {
		Integer driverId = (Integer) model.getAttribute("driverId");
		Driver driver=driverservice.findById(driverId);
		model.addAttribute(driver);
		return "driver/editdri";
	}
	
	@PostMapping("/editdriverdetails")
	public String driverupdatedetails(@ModelAttribute("driver")Driver driver,Model model)
	{
		Driver dr=driverservice.updateDriver(driver);
		if(dr!=null)
			return "driver/modifysuccess";
		else
			return "driver/modifyunsuccess";
	}
	
	//using session view
	@GetMapping("/viewdetails")
	public String viewdri( Model model) {
		Integer driverId = (Integer) model.getAttribute("driverId");
		Driver driver=driverservice.findById(driverId);
		model.addAttribute("driver",driver);
		return "driver/viewdri";
	}
	
	//getalldriversforadmin
		@GetMapping("/getalldrivers")
		public String getlistDrivers(Model model)
		{
			List<Driver> lists=driverservice.findall();
			if(lists.size()>0)
			{
			model.addAttribute("driver",lists);
			return "driver/getlistdrivers";
			}
			else
				return "driver/fetchunsuccessadmin";
		}
	
	//using session view and delete for admin in table
	@GetMapping("/viewdrivers")
	public String viewtrip(@org.springframework.web.bind.annotation.RequestParam("driverId")Integer driverId, Model model) {
		
		Driver drivers = driverservice.findById(driverId);
		model.addAttribute("drivers", drivers);
		return "driver/viewdriv";
	}
	
	@GetMapping("/deldri")
	public String deldriv(@org.springframework.web.bind.annotation.RequestParam("driverId")Integer driverId, Model model) {
		
		Driver drivers = driverservice.findById(driverId);
		model.addAttribute("drivers", drivers);
		return "driver/viewdeldriver";
	}
	
	@PostMapping("/deldri")
	public String fetchdeldri(@ModelAttribute("drivers")Driver drivers,Model model)
	{
		Driver dr=driverservice.findById(drivers.getDriverId());
		List<Cab> list=cabservice.findallcabs();
		for(Cab cab:list)
		{
			if(cab.getCabId()==dr.getCab().getCabId())
				cab.setDriver(null);
		}
		dr.setCab(null);
		if(driverservice.deleteDriver(drivers.getDriverId())!=null)
			return "driver/deletesuccess";
		else
			return "driver/deleteunsuccess";
	}
	
	//for customer driver details
	
	@GetMapping("/viewcusdriver")
	public String viewcusdri(@org.springframework.web.bind.annotation.RequestParam("driverId")Integer driverId, @org.springframework.web.bind.annotation.RequestParam("tripbookingId")Integer tripbookingId,Model model) {
		
		Driver drivers = driverservice.findById(driverId);
		model.addAttribute("drivers", drivers);
		TripBooking trip=tripbookingservice.findById(tripbookingId);
		if(trip.getToDateTime().isBefore(LocalDateTime.now())&& trip.getStatus()==true)
			return "driver/rating";
		return "driver/viewcusdriv";
	}
	
//	//rate driver
	@PostMapping("/rate")
	public String ratedriv(@ModelAttribute("drivers")Driver drivers, Model model)
	{
		Driver driver=driverservice.findById(drivers.getDriverId());
		Float rat=drivers.getRating();
		driver.setRating(rat);
		driverservice.updateDriver(driver);
		return "driver/ratedrivers";
	}
	
}
