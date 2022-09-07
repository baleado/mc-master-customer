package com.jpaa.mastercard.mc.services.customer.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jpaa.mastercard.mc.repository.entity.McCustomer;
import com.jpaa.mastercard.mc.repository.repository.McCustomerRepository;
import com.jpaa.mastercard.mc.services.customer.ICustomerService;
import com.jpaa.mastercard.mc.services.exception.CustomerNotFoundException;
import com.jpaa.mastercard.mc.services.model.Address;
import com.jpaa.mastercard.mc.services.model.AddressConvertor;
import com.jpaa.mastercard.mc.services.model.Customer;
import com.jpaa.mastercard.mc.services.model.CustomerConvertor;
import com.jpaa.mastercard.mc.services.model.Page;

@Service
public class CustomerService implements ICustomerService {

	private McCustomerRepository customerRepository;

	public CustomerService(McCustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		McCustomer mcCustomer = customerRepository.save(CustomerConvertor.toMcCustomer(customer));
		return CustomerConvertor.toCustomer(mcCustomer);
	}

	@Override
	public Customer getCustomer(Long customerId) {
		McCustomer mcCustomer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException(customerId.toString()));
		return CustomerConvertor.toCustomer(mcCustomer);
	}

	@Override
	public List<Address> getCustomerAddresses(Long customerId) {
		McCustomer mcCustomer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException(customerId.toString()));
		return mcCustomer.getAddresses().stream().map(AddressConvertor::toAddress).collect(Collectors.toList());
	}

	@Override
	public Page<Customer> getCustomers(Customer example, Integer page, Integer recordsPerPage) {
		org.springframework.data.domain.Page<McCustomer> customers = customerRepository.findAll(
				Example.of(Optional.of(CustomerConvertor.toMcCustomer(example)).orElse(new McCustomer())),
				PageRequest.of(page - 1, recordsPerPage));
		Page<Customer> pageCustomers = new Page<>();
		pageCustomers.setTotalElements(customers.getTotalElements());
		pageCustomers.setTotalPages(customers.getTotalPages());
		pageCustomers.setPageSize(customers.getNumberOfElements());
		pageCustomers.setPageNumber(customers.getNumber() + 1);
		pageCustomers.setData(customers.stream().map(CustomerConvertor::toCustomer).collect(Collectors.toList()));
		return pageCustomers;

	}

	@Override
	public void deleteCustomer(Long customerId) {
		Optional<McCustomer> mcCustomer = customerRepository.findById(customerId);
		customerRepository.delete(mcCustomer.orElseThrow(() -> new CustomerNotFoundException(customerId.toString())));
	}

}
