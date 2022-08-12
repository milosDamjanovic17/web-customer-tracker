package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.ICustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	// need to inject the customer dao
	@Autowired
	private ICustomerService customerService;
	
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
			
		// get customers from the service
		List<Customer> customerList = customerService.getCustomers();
		
		// add the customers to the model(Model theModel)
		theModel.addAttribute("customerList", customerList);
		
		
		return "list-customers";
	}
	
	
	
}
