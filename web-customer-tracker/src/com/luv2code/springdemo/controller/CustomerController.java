package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.ICustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	// need to inject the customer dao
	@Autowired
	private ICustomerService customerService;
	
	
	// METODA VRACA LISTU CUSTOMERA
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
			
		// get customers from the service
		List<Customer> customerList = customerService.getCustomers();
		
		// add the customers to the model(Model theModel)
		theModel.addAttribute("customerList", customerList);
		
		
		return "list-customers";
	}
	
	
	// METODA PRIKAZUJE ADD CUSTOMER FORMU I BINDUJE PODATKE SA theCustomer NA "customer" ATTRIBUTE
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		
		// create model attribute to bind form data
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		
		//save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		
		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);
		
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		
		// send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete") // => value="/customer/delete" iz list-customers.jsp strane
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		//delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	
	
	
}
