package com.jpaa.mastercard.mc.web.controller.address;

import org.springframework.validation.BindingResult;

import com.jpaa.mastercard.mc.services.model.Address;
import com.jpaa.mastercard.mc.web.model.Response;
import com.jpaa.mastercard.mc.web.model.ResponsePage;

public interface IAddressController {

	Response<Address> createAddress(Address address, BindingResult bindingResult);

	Response<Address> getAddress(Long addressId);

	ResponsePage<Address> getAddresses(Address addressExample, Integer page, Integer recordsPerPage);

	Response<Void> deleteAddress(Long addressId);

}
