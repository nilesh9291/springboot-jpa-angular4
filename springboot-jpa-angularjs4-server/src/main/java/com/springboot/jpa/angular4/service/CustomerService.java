package com.springboot.jpa.angular4.service;

import java.util.List;

import com.springboot.jpa.angular4.model.Customer;

public interface CustomerService {

	Customer findById(long id);

	List<Customer> findByLastName(String name);

	void save(Customer Customer);

	void update(Customer Customer);

	void delete(long id);

	List<Customer> findAll();

	void deleteAll();

	boolean isCustomerExist(String name);

}
