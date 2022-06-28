package ro.dcatalin.byblios.dao;

import java.util.List;

import ro.dcatalin.byblios.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public void saveCustomer(Customer theCustomer);
}
