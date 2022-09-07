package com.jpaa.mastercard.mc.services.address;

import com.jpaa.mastercard.mc.services.model.Address;
import com.jpaa.mastercard.mc.services.model.Page;

public interface IAddressService {

	Address createAddress(Address address);

	Address getAddress(Long addressId);

	Page<Address> getAddresses(Address example, Integer page, Integer recordsPerPage);

	void deleteAddress(Long addressId);
}
