package com.jpaa.mastercard.mc.web.controller.customer;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

import com.jpaa.mastercard.mc.services.model.Address;
import com.jpaa.mastercard.mc.services.model.Customer;
import com.jpaa.mastercard.mc.web.model.Response;
import com.jpaa.mastercard.mc.web.model.ResponsePage;

public interface ICustomerController {

	Response<Customer> createCustomer(Customer customer, BindingResult bindingResult);

	Response<Customer> getCustomer(Long customerId);

	ResponsePage<Customer> getCustomers(Customer customerExample, Integer page, Integer recordsPerPage);

	Response<Void> deleteCustomer(Long customerId);

	Response<List<Address>> getCustomerAddresses(@PathVariable Long customerId);
}
