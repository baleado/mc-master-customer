package com.jpaa.mastercard.mc.web.controller.address.impl;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpaa.mastercard.mc.services.address.IAddressService;
import com.jpaa.mastercard.mc.services.address.impl.AddressService;
import com.jpaa.mastercard.mc.services.exception.ParameterValidatorException;
import com.jpaa.mastercard.mc.services.model.Address;
import com.jpaa.mastercard.mc.services.model.Page;
import com.jpaa.mastercard.mc.web.controller.address.IAddressController;
import com.jpaa.mastercard.mc.web.model.Response;
import com.jpaa.mastercard.mc.web.model.ResponsePage;

@RestController
@RequestMapping("/address")
public class AddressController implements IAddressController {

	private final IAddressService addressService;

	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@Override
	@PostMapping
	public Response<Address> createAddress(@RequestBody @Valid Address address, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ParameterValidatorException(bindingResult.getAllErrors());
		}
		return new Response<>(addressService.createAddress(address));
	}

	@Override
	@GetMapping(path = "/{addressId}/addresses")
	public Response<Address> getAddress(@PathVariable Long addressId) {
		return new Response<>(addressService.getAddress(addressId));
	}

	@Override
	@GetMapping
	public ResponsePage<Address> getAddresses(Address addressExample, Integer page, Integer recordsPerPage) {
		Page<Address> addresses = addressService.getAddresses(addressExample, page, recordsPerPage);
		final ResponsePage<Address> response = new ResponsePage<>();
		response.setPageNumber(addresses.getPageNumber());
		response.setPageSize(addresses.getPageSize());
		response.setNumberOfElements(addresses.getPageSize());
		response.setTotalPages(addresses.getTotalPages());
		response.setTotalElements(addresses.getTotalElements());
		response.setData(addresses.getData());
		return response;
	}

	@Override
	@DeleteMapping(path = "/{addressId}")
	public Response<Void> deleteAddress(@PathVariable Long addressId) {
		addressService.deleteAddress(addressId);
		return new Response<>();
	}

}
