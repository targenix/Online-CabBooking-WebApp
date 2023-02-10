package org.cabbookingweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	@GetMapping("/message")
	public String getmessage(Model model)
	{
		model.addAttribute("name","ARCHANA");
		return "msg";
	}
	@GetMapping("/message1")
	public String getmessage1()
	{
		return "msg1";
	}
}
