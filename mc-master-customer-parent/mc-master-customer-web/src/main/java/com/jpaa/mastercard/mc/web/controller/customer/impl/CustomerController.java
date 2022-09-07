package com.jpaa.mastercard.mc.web.controller.customer.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpaa.mastercard.mc.services.customer.ICustomerService;
import com.jpaa.mastercard.mc.services.customer.impl.CustomerService;
import com.jpaa.mastercard.mc.services.exception.ParameterValidatorException;
import com.jpaa.mastercard.mc.services.model.Address;
import com.jpaa.mastercard.mc.services.model.Customer;
import com.jpaa.mastercard.mc.services.model.Page;
import com.jpaa.mastercard.mc.web.controller.customer.ICustomerController;
import com.jpaa.mastercard.mc.web.model.Response;
import com.jpaa.mastercard.mc.web.model.ResponsePage;

@RestController
@RequestMapping("/customer")
public class CustomerController implements ICustomerController {

	private final ICustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	@PostMapping
	public Response<Customer> createCustomer(@RequestBody @Valid Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ParameterValidatorException(bindingResult.getAllErrors());
		}
		return new Response<>(customerService.createCustomer(customer));
	}

	@Override
	@GetMapping(path = "/{customerId}")
	public Response<Customer> getCustomer(@PathVariable Long customerId) {
		return new Response<>(customerService.getCustomer(customerId));
	}

	@Override
	@GetMapping(path = "/{customerId}/addresses")
	public Response<List<Address>> getCustomerAddresses(@PathVariable Long customerId) {
		return new Response<>(customerService.getCustomerAddresses(customerId));
	}

	@Override
	@GetMapping
	public ResponsePage<Customer> getCustomers(Customer customerExample,
			@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(name = "recordsPerPage", required = false, defaultValue = "10") Integer recordsPerPage) {
		Page<Customer> customers = customerService.getCustomers(customerExample, page, recordsPerPage);
		final ResponsePage<Customer> response = new ResponsePage<>();
		response.setPageNumber(customers.getPageNumber());
		response.setPageSize(customers.getPageSize());
		response.setNumberOfElements(customers.getPageSize());
		response.setTotalPages(customers.getTotalPages());
		response.setTotalElements(customers.getTotalElements());
		response.setData(customers.getData());
		return response;
	}

	@Override
	@DeleteMapping(path = "/{customerId}")
	public Response<Void> deleteCustomer(@PathVariable Long customerId) {
		customerService.deleteCustomer(customerId);
		return new Response<>();
	}
}
