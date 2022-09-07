package com.jpaa.mastercard.mc.services.model;

import java.util.Optional;

import com.jpaa.mastercard.mc.repository.entity.McCustomer;

public class CustomerConvertor {

	private CustomerConvertor() {

	}

	public static Customer toCustomer(McCustomer mcCustomer) {
		if (mcCustomer == null) {
			return null;
		}
		Customer customer = new Customer();
		customer.setId(mcCustomer.getId());
		customer.setFirstName(mcCustomer.getFirstName());
		customer.setLastName(mcCustomer.getLastName());
		return customer;
	}

	public static Customer toCustomer(Optional<McCustomer> mcCustomer) {
		return mcCustomer.isPresent() ? toCustomer(mcCustomer.get()) : null;
	}

	public static McCustomer toMcCustomer(Customer customer) {
		if (customer == null) {
			return null;
		}
		McCustomer mcCustomer = new McCustomer();
		mcCustomer.setId(customer.getId());
		mcCustomer.setFirstName(customer.getFirstName());
		mcCustomer.setLastName(customer.getLastName());
		return mcCustomer;
	}

	public static McCustomer toMcCustomer(Optional<Customer> customer) {
		return customer.isPresent() ? toMcCustomer(customer.get()) : null;
	}
}
