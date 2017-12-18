package com.springboot.jpa.angular4.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.angular4.model.Customer;
import com.springboot.jpa.angular4.repo.CustomerRepository;
import com.springboot.jpa.angular4.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {	
	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<Customer>();
		
		customerRepository.findAll().forEach(customers::add);
		return customers;
	}
	
	public Customer findById(long id) {
		return customerRepository.findOne(id);
	}

	public List<Customer> findByLastName(String name) {		
		return customerRepository.findByLastName(name);
	}

	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	public void update(Customer customer) {
		customerRepository.save(customer);
	}

	public void delete(long id) {
		customerRepository.delete(id);
	}

	public boolean isCustomerExist(String name) {
		boolean flag = false;
		Customer customer = customerRepository.findByFirstName(name);
		
		if(customer == null) {
			flag= false;			
		}
		
		return flag;
	}

	public void deleteAll() {
		customerRepository.deleteAll();
	}

}
