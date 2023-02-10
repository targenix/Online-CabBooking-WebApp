package org.cabbookingweb.controller;


import java.util.List;

import org.cabbookingweb.entities.Admin;
import org.cabbookingweb.entities.Cab;
import org.cabbookingweb.entities.Customer;
import org.cabbookingweb.entities.Driver;
import org.cabbookingweb.service.CabService;
import org.cabbookingweb.service.DriverService;
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
@RequestMapping("/cab")
@SessionAttributes("customerId")
@Scope("request")
public class CabController {
	@Autowired
	private CabService cabservice;
	
	@Autowired
	private DriverService driverservice;
	@GetMapping("/addcab")
	public String addcab(Model model)
	{
		Cab cab=new Cab();
		model.addAttribute("cab",cab);
		return "cab/addcab";
	}
	
	@PostMapping("/addcab")
	public String processaddadmin(@ModelAttribute("cab")Cab cab)
	{
		cab.setAvailable(true);
		List<Driver> list=driverservice.findall();
		for(Driver driver:list)
		{
			if(driver.getDriverId()==cab.getDriver().getDriverId())
				driver.setCab(cab);
		}
		Cab c=cabservice.addCab(cab);
		if(c==null)
			return "cab/addunsuccess";
		else
			return "cab/addsuccess";
		}
	
	//modifycabrecord
	
//	@GetMapping("/modifycab")
//	public String modifycab(Model model)
//	{
//		Cab cab=new Cab();
//		model.addAttribute(cab);
//		return "cab/modifycab";
//	}
//	
//	@PostMapping("/fetchcab")
//	public String fetchadmin(@ModelAttribute("cab") Cab cab,Model model)
//	{
//		 cab=cabservice.findById(cab.getCabId());
//		if(cab!=null)
//		{
//       model.addAttribute("cab",cab);
//			return "cab/fetchsuccess";
//		}
//		else
//		{
//			
//			return "cab/fetchunsuccess";
//		}
//	}
//	
//	@PostMapping("/modifycab")
//	public String processmodifycab(@ModelAttribute("cab")Cab cab)
//	{
//		Cab c=cabservice.updateCab(cab);
//		if(c!=null)
//			return "cab/modifysuccess";
//		else
//			return "cab/modifyunsuccess";
//	}
	
	//deletecabrecord
	
//	@GetMapping("/deletecab")
//	public String deletecab(Model model)
//	{
//		Cab cab=new Cab();
//		model.addAttribute(cab);
//		return "cab/deletecab";
//	}
//	
//	@PostMapping("/fetchdeletecab")
//	public String fetchfordeletecab(@ModelAttribute("cab") Cab cab,Model model)
//	{
//	    cab=cabservice.findById(cab.getCabId());
//	    if(cab!=null)
//		{
//			model.addAttribute("cab",cab);
//			return "cab/fetchdeletesuccess";
//		}
//		else
//		{
//			
//			return "cab/fetchunsuccess";
//		}
//	}
//	
//	@PostMapping("/deletecab")
//	public String processdeletecab(@ModelAttribute("cab")Cab cab)
//	{
//		Cab c=cabservice.deleteCab(cab.getCabId());
//		if(c!=null)
//			return "cab/deletesuccess";
//		else
//			return "cab/deleteunsuccess";
//	}
	
	//findbyid
	
	@GetMapping("/findcab")
	public String findcab(Model model)
	{
		Cab cab=new Cab();
		model.addAttribute(cab);
		return "cab/findcab";
	}
	
	@PostMapping("/fetchcabdetails")
	public String fetchcabdetails(@ModelAttribute("cab") Cab cab,Model model)
	{
		cab=cabservice.findById(cab.getCabId());
		if(cab!=null)
		{
			model.addAttribute("cab",cab);
			return "cab/findsuccess";
		}
		else
		{
			
			return "cab/fetchunsuccess";
		}
	}
	
	//findbycartype
	
	@GetMapping("/findbycabtype")
	public String findcarType(Model model)
	{
		Cab cab=new Cab();
		model.addAttribute(cab);
		return "cab/findcabbytype";
	}
	
	
	@PostMapping("/findbycabtype")
	public String fetchcabdata(@ModelAttribute("cab")Cab cab ,Model model)
	{
		List<Cab> lists=cabservice.findBycabType(cab.getCarType());
		if(lists!=null)
		{
			model.addAttribute("lists",lists);
			return "cab/listofcabs";
		}
		else
		{
			
			return "cab/fetchunsuccess";
		}
	}
	
	//countbycabtype
	@GetMapping("/countcabbytype")
	public String countcabtype(Model model)
	{
		Cab cab=new Cab();
		model.addAttribute("cab",cab);
		return "cab/countcabbytype";
	}
	
	@PostMapping("/countcabbytype")
	public String fetchcabcounts(@ModelAttribute("cab")Cab cab ,Model model)
	{
		Integer count=cabservice.countBycabType(cab.getCarType());
		if(count!=0)
		{
			model.addAttribute("count",count);
			
			return "cab/countcabs";
		}
		else
		{
			
			return "cab/fetchunsuccess";
		}
	}
	//in main page book cab
	@GetMapping("/getcabs")
	public String getCabs(Model model)
	{
		Integer customerId=(Integer) model.getAttribute("customerId");
		System.out.println(customerId);
		List<Cab> lists=cabservice.checkavailable();
		if(lists.size()>0)
		{
		model.addAttribute("cabs",lists);
		return "cab/cablists";
		}
		else
			return"cab/cabnotavailable";
	}
	
	//findallcabs
	
	@GetMapping("/listcabs")
	public String getCablist(Model model)
	{
		List<Cab> lists=cabservice.findallcabs();
		if(lists.size()>0)
		{
		model.addAttribute("cabs",lists);
		return "cab/listcabs";
		}
		else
			return"cab/fetchunsuccess";
	}
	
	//updatecab
	@GetMapping("/updatedetails")
	public String updcab(@RequestParam("cabId")Integer cabId,Model model)
	{		
	    Cab cab = cabservice.findById(cabId);
		model.addAttribute(cab);
		return "cab/fetchsuccess";
	}
	
	@PostMapping("/updatedetails")
	public String fetchupddetails(@ModelAttribute("cab")Cab cab,Model model)
	{
		Cab ca=cabservice.updateCab(cab);
		if(ca!=null)
			return "cab/modifysuccess";
		else
			return "cab/modifyunsuccess";
	}
	
	@GetMapping("/deldetails")
	public String delcab(@RequestParam("cabId")Integer cabId,Model model)
	{		
	    Cab cab = cabservice.findById(cabId);
		model.addAttribute(cab);
		return "cab/fetchdeletesuccess";
	}
	
	@PostMapping("/deldetails")
	public String fetchdeldetails(@ModelAttribute("cab")Cab cab,Model model)
	{
		Cab ca=cabservice.findById(cab.getCabId());
		List<Driver> list=driverservice.findall();
		for(Driver driver:list)
		{
			if(driver.getDriverId()==ca.getDriver().getDriverId())
				driver.setCab(null);
		}
		ca.setDriver(null);
		if(cabservice.deleteCab(ca.getCabId())!=null)
			return "cab/deletesuccess";
		else
			return "cab/deleteunsuccess";
	}

}
