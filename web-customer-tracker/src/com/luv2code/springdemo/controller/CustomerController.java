package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.ICustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	// need to inject the customer dao
	@Autowired
	private ICustomerDAO customerDAO;
	
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
			
		// get customers from the DAO
		List<Customer> customerList = customerDAO.getCustomer();
		
		// add the customers to the model(Model theModel)
		theModel.addAttribute("customerList", customerList);
		
		
		return "list-customers";
	}
	
	
	
}
