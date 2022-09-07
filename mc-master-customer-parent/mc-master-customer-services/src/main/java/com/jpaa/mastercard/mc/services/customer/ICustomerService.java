package com.jpaa.mastercard.mc.services.customer;

import java.util.List;

import com.jpaa.mastercard.mc.services.model.Address;
import com.jpaa.mastercard.mc.services.model.Customer;
import com.jpaa.mastercard.mc.services.model.Page;

public interface ICustomerService {

	Customer createCustomer(Customer customer);

	Customer getCustomer(Long customerId);

	Page<Customer> getCustomers(Customer example, Integer page, Integer recordsPerPage);

	void deleteCustomer(Long customerId);

	List<Address> getCustomerAddresses(Long customerId);

}
