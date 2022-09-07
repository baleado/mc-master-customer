package com.jpaa.mastercard.mc.services.model;

import java.util.Optional;

import com.jpaa.mastercard.mc.repository.entity.McAddress;
import com.jpaa.mastercard.mc.repository.entity.McAddressType;
import com.jpaa.mastercard.mc.repository.entity.McCustomer;

public class AddressConvertor {

	private AddressConvertor() {

	}

	public static Address toAddress(McAddress mcAddress) {
		if (mcAddress == null) {
			return null;
		}
		Address address = new Address();
		address.setId(mcAddress.getId());
		address.setStreet(mcAddress.getStreet());
		address.setState(mcAddress.getState());
		address.setCountry(mcAddress.getCountry());
		address.setZipCode(mcAddress.getZipCode());
		address.setCustomerId(mcAddress.getId());
		if (mcAddress.getAddressType() != null) {
			address.setAddressType(AddressType.valueOf(mcAddress.getAddressType().name()));
		}
		return address;
	}

	public static Address toAddress(Optional<McAddress> mcAddress) {
		return mcAddress.isPresent() ? toAddress(mcAddress.get()) : null;
	}

	public static McAddress toMcAddress(Address address) {
		McAddress mcAddress = new McAddress();
		mcAddress.setId(address.getId());
		mcAddress.setStreet(address.getStreet());
		mcAddress.setState(address.getState());
		mcAddress.setCountry(address.getCountry());
		mcAddress.setZipCode(address.getZipCode());
		mcAddress.setCustomer(new McCustomer());
		mcAddress.getCustomer().setId(address.getCustomerId());
		if (address.getAddressType() != null) {
			mcAddress.setAddressType(McAddressType.valueOf(address.getAddressType().name()));
		}
		return mcAddress;
	}

	public static McAddress toMcAddress(Optional<Address> address) {
		return address.isPresent() ? toMcAddress(address.get()) : null;
	}
}
