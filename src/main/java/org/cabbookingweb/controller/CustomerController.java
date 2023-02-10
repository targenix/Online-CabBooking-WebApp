package org.cabbookingweb.controller;


import java.util.List;

import org.cabbookingweb.entities.Customer;
import org.cabbookingweb.entities.Driver;
import org.cabbookingweb.entities.TripBooking;
import org.cabbookingweb.service.CustomerService;
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
@RequestMapping("/customer")
@SessionAttributes("customerId")
@Scope("request")
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping("/addcustomer")
	public String addcustomer(Model model)
	{
		Customer customer=new Customer();
		model.addAttribute("customer",customer);
		return "customer/addcustomer";
	}
	
	@PostMapping("/addcustomer")
	public String processaddcustomer(@ModelAttribute("customer")Customer customer)
	{
		if(customerservice.findcustomerbyusername(customer.getUserName())==null)
		{
		  customerservice.addCustomer(customer);
		  return "customer/addsuccess";
//		   if(cus==null)
//			return "customer/addunsuccess";
		}
			return "customer/addunsuccess";
		}
	
	@GetMapping("/modifycustomer")
	public String modifycustomer(Model model)
	{
		Customer customer=new Customer();
		model.addAttribute(customer);
		return "customer/modifycustomer";
	}
	
	@PostMapping("/fetchcustomer")
	public String fetchcustomer(@ModelAttribute("customer") Customer customer,Model model)
	{
		customer=customerservice.findById(customer.getCustomerId());
		if(customer!=null)
		{
			model.addAttribute("customer",customer);
			return "customer/fetchsuccess";
		}
		else
		{
			
			return "customer/fetchunsuccess";
		}
	}
	
	@PostMapping("/modifycustomer")
	public String processmodifycustomer(@ModelAttribute("customer") Customer customer)
	{
		Customer cust=customerservice.updateCustomer(customer);
		if(cust!=null)
			return "customer/modifysuccess";
		else
			return "customer/modifyunsuccess";
	}
	
	
	//Delete
	
	@GetMapping("/deletecustomer")
	public String deletecustomer(Model model)
	{
		Customer customer=new Customer();
		model.addAttribute(customer);
		return "customer/deletecustomer";
	}
	
	@PostMapping("/fetchdeletecustomer")
	public String fetchfordeleteadmin(@ModelAttribute("customer") Customer customer,Model model)
	{
		customer=customerservice.findById(customer.getCustomerId());
		if(customer!=null)
		{
			model.addAttribute("customer",customer);
			return "customer/fetchdeletesuccess";
		}
		else
		{
			
			return "customer/fetchunsuccess";
		}
	}

	
	@PostMapping("/deletecustomer")
	public String processdeletecustomer(@ModelAttribute("customer")Customer customer)
	{
		Customer cust=customerservice.deleteCustomer(customer.getCustomerId());
		if(cust!=null)
			return "customer/deletesuccess";
		else
			return "customer/deleteunsuccess";
	}
	
	
	//Find by id
	
	
	@GetMapping("/findcustomer")
	public String findcustomer(Model model)
	{
		Customer customer=new Customer();
		model.addAttribute(customer);
		return "customer/findcustomer";
	}
	
	@PostMapping("/fetchcustomerdetails")
	public String fetchcustomerdetails(@ModelAttribute("customer") Customer customer,Model model)
	{
		customer=customerservice.findById(customer.getCustomerId());
		if(customer!=null)
		{
			model.addAttribute("customer",customer);
			return "customer/findsuccess";
		}
		else
		{
			
			return "customer/fetchunsuccess";
		}
	}
	
	//validate customer
	
//	@GetMapping("/login")
//	public String logincustomer(Model model)
//	{
//		Customer customer=new Customer("","");
//		model.addAttribute("customer",customer);
//		return "customer/logincustomer"; 
//		
//	}
//	
//	@PostMapping("/validcustomer")
//	public String validcustomer(@ModelAttribute("customer") Customer customer,Model model)
//	{
//		if(customerservice.validateCustomer(customer.getUserName(),customer.getPassword())!=null)
//			return "customer/profile"; //here add welcome $name then logged in
//		else
//			return "customer/profilenotfound";
//	}
	
	
	//findall customers
	
	
	@GetMapping("/findallcustomers")
	public String listCustomers(Model model)
	{
		List<Customer> lists=customerservice.findAll();
		model.addAttribute("lists",lists);
		if(lists.size()>0)
		return "customer/listcustomers";
		else
			return "customer/fetchunsuccess";
	}
	

	//using session update
	
	@GetMapping("/updatedetails")
	public String updatecus( Model model) {
		Integer customerId = (Integer) model.getAttribute("customerId");
		Customer customer=customerservice.findById(customerId);
		model.addAttribute(customer);
		return "customer/editcus";
	}
	
	@PostMapping("/updatedetails")
	public String fetchupdatetrip(@ModelAttribute("customer")Customer customer,Model model)
	{
		Customer cu=customerservice.updateCustomer(customer);
		if(cu!=null)
			return "customer/modifysuccess";
		else
			return "customer/modifyunsuccess";
	}
	
	//using session delete
	@GetMapping("/deldetails")
	public String delcus( Model model) {
		Integer customerId = (Integer) model.getAttribute("customerId");
		Customer customer=customerservice.findById(customerId);
		model.addAttribute(customer);
		return "customer/delcus";
	}
	
	@PostMapping("/deldetails")
	public String fetchdeldetails(@ModelAttribute("customer")Customer customer,Model model)
	{
		Customer cu=customerservice.deleteCustomer(customer.getCustomerId());
		if(cu!=null)
			return "customer/deletesuccess";
		else
			return "customer/deleteunsuccess";
	}
	
	@GetMapping("/viewdrivercus")
	public String viewcusdriv(@org.springframework.web.bind.annotation.RequestParam("customerId")Integer customerId, Model model) {
		
		Customer customer = customerservice.findById(customerId);
		model.addAttribute("customer", customer);
		return "customer/viewdrivcus";
	}

}
