package ro.dcatalin.byblios.service;

import java.util.List;

import ro.dcatalin.byblios.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
