package com.springboot.jpa.angular4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.angular4.model.Customer;
import com.springboot.jpa.angular4.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping(value="/customer",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAll() {
		List<Customer> list = new ArrayList<>();
		Iterable<Customer> customers = customerService.findAll();

		customers.forEach(list::add);
		return list;
	}
		
	@PostMapping(value="/save")
	public Customer save(@RequestBody Customer customer) {
		customerService.save(new Customer(customer.getFirstName(), customer.getLastName()));
		return customer;
	}

	@GetMapping(value="/findbylastname/{lastName}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findByLastName(@PathVariable String lastName) {

		List<Customer> customers = customerService.findByLastName(lastName);
		return customers;
	}
	
	@DeleteMapping(value="/customer/{id}")
	public void deleteCustomer(@PathVariable long id){		
		customerService.delete(id);
	}
}
