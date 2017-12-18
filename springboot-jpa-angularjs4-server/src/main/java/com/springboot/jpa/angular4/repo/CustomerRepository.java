package com.springboot.jpa.angular4.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.angular4.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByFirstName(String firstName);
	
	List<Customer> findByLastName(String lastName);
}