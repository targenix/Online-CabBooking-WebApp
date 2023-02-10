package org.cabbookingweb.controller;

import org.cabbookingweb.dto.LoginToken;
import org.cabbookingweb.entities.Admin;
import org.cabbookingweb.entities.Customer;
import org.cabbookingweb.entities.Driver;
import org.cabbookingweb.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/login")
@SessionAttributes({"customerId","adminId","driverId"})
public class LoginController {
	
	
	@Autowired
	private LoginServiceImpl loginservice;
	
	@GetMapping
	public String login(Model model)
	{
		LoginToken token=new LoginToken();
		model.addAttribute("logintoken",token);
		return "login/login";
	}
	
	@PostMapping
	public String checklogin(@ModelAttribute("logintoken")LoginToken token,Model model)
	{
		Customer customer=loginservice.checklogin(token);
		if(customer!=null)
		{
			model.addAttribute("customerId",customer.getCustomerId());
			return "login/profile";
		}
		return "login/profilenotfound";
	}
	
	//admin login
	@GetMapping("/adminlogin")
	public String adminlogin(Model model)
	{
		LoginToken token=new LoginToken();
		model.addAttribute("logintoken",token);
		return "login/adminlogin";
	}
	
	@PostMapping("/adminlogin")
	public String checkadminlogin(@ModelAttribute("logintoken")LoginToken token,Model model)
	{
		Admin admin=loginservice.checkloginadmin(token);
		if(admin!=null)
		{
			model.addAttribute("adminId",admin.getAdminId());
			return "login/adminprofile";
		}
		return "login/adminprofilenotfound";
	}
	//driver login
	
	@GetMapping("/driverlogin")
	public String driverlogin(Model model)
	{
		LoginToken token=new LoginToken();
		model.addAttribute("logintoken",token);
		return "login/driverlogin";
	}
	
	@PostMapping("/driverlogin")
	public String checkdriverlogin(@ModelAttribute("logintoken")LoginToken token,Model model)
	{
		Driver driver=loginservice.checklogindriver(token);
		if(driver!=null)
		{
			model.addAttribute("driverId",driver.getDriverId());
			return "login/driverprofile";
		}
		return "login/driverprofilenotfound";
	}
	

}
