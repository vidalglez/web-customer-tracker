package com.example.server.service;

import java.util.List;

import com.example.server.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public void deleteCustomer(int id);

	public List<Customer> searchCustomer(String name);
}
