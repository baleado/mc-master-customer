package com.jpaa.mastercard.mc.starter.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import com.jpaa.mastercard.mc.services.address.impl.AddressService;
import com.jpaa.mastercard.mc.services.customer.impl.CustomerService;
import com.jpaa.mastercard.mc.services.exception.CustomerNotFoundException;
import com.jpaa.mastercard.mc.services.model.Address;
import com.jpaa.mastercard.mc.services.model.AddressType;
import com.jpaa.mastercard.mc.services.model.Customer;
import com.jpaa.mastercard.mc.services.model.Page;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MasterCustomerTest {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AddressService addressService;

	@Test
	public void whenCustomerCreated_thenCustomerShouldBeFound() {

		final String firstName = "whenCustomerCreated_thenCustomerShouldBeFound";
		final String lastName = "whenCustomerCreated_thenCustomerShouldBeFound";

		Customer customerToCreate = new Customer();
		customerToCreate.setFirstName(firstName);
		customerToCreate.setLastName(lastName);
		Customer c = customerService.createCustomer(customerToCreate);
		Assert.assertTrue(c.getId() > 0);

		Customer customerReturned = customerService.getCustomer(c.getId());
		Assert.assertEquals(c, customerReturned);
	}

	@Test
	public void whenCustomerCreated_thenCustomerAddressShouldBeZero() {

		final String firstName = "whenCustomerCreated_thenCustomerAddressShouldBeZero";
		final String lastName = "whenCustomerCreated_thenCustomerAddressShouldBeZero";

		Customer customerToCreate = new Customer();
		customerToCreate.setFirstName(firstName);
		customerToCreate.setLastName(lastName);
		Customer c = customerService.createCustomer(customerToCreate);
		Assert.assertTrue(c.getId() > 0);

		List<Address> addresses = customerService.getCustomerAddresses(c.getId());
		Assert.assertTrue(CollectionUtils.isEmpty(addresses));
	}

	@Test(expected = CustomerNotFoundException.class)
	public void whenCustomerDoesNotExists_thenCustomerNotFoundErrorShouldBeRaised() {
		customerService.getCustomer(0L);
	}

	@Test
	public void whenCustomerCreated_thenAtItMustBePresentInCustomersList() {

		final String firstName = "whenCustomerCreated_thenAtItMustBePresentInCustomersList";
		final String lastName = "whenCustomerCreated_thenAtItMustBePresentInCustomersList";

		Customer customerToCreate = new Customer();
		customerToCreate.setFirstName(firstName);
		customerToCreate.setLastName(lastName);
		Customer c = customerService.createCustomer(customerToCreate);
		Assert.assertTrue(c.getId() > 0);

		Page<Customer> customers = customerService.getCustomers(c, 1, 1);
		Assert.assertEquals(c, customers.getData().get(0));
	}

	@Test
	public void whenCustomerIsDeleted_allAddressesShouldBeDeleted() {

		final String firstName = "whenCustomerIsDeleted_allAddressesShouldBeDeleted";
		final String lastName = "whenCustomerIsDeleted_allAddressesShouldBeDeleted";

		// Create customer
		Customer customerToCreate = new Customer();
		customerToCreate.setFirstName(firstName);
		customerToCreate.setLastName(lastName);
		Customer c = customerService.createCustomer(customerToCreate);
		Assert.assertTrue(c.getId() > 0);

		// Add addresses
		Address address = new Address();
		address.setStreet("Rua da avenida");
		address.setState("Lisboa");
		address.setCountry("PT");
		address.setZipCode("12345");
		address.setCustomerId(c.getId());
		address.setAddressType(AddressType.BILLING);
		Address addressCreated = addressService.createAddress(address);
		Assert.assertTrue(addressCreated.getId() > 0);

		// Check if there is any address associated to that customer
		Address filterAddress = new Address();
		filterAddress.setCustomerId(c.getId());
		Page<Address> addressesBeforeDelete = addressService.getAddresses(filterAddress, 1, 10);
		Assert.assertEquals(addressCreated, addressesBeforeDelete.getData().get(0));

		// Delete customer
		customerService.deleteCustomer(c.getId());

		// Check if there is any address associated to that customer it shouldn't
		Page<Address> addressesAfterDelete = addressService.getAddresses(filterAddress, 1, 10);
		Assert.assertTrue(CollectionUtils.isEmpty(addressesAfterDelete.getData()));
	}
}
