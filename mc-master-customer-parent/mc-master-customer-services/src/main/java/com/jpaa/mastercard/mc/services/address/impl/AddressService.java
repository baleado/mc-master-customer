package com.jpaa.mastercard.mc.services.address.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jpaa.mastercard.mc.repository.entity.McAddress;
import com.jpaa.mastercard.mc.repository.repository.McAddressRepository;
import com.jpaa.mastercard.mc.services.address.IAddressService;
import com.jpaa.mastercard.mc.services.exception.AddressNotFoundException;
import com.jpaa.mastercard.mc.services.model.Address;
import com.jpaa.mastercard.mc.services.model.AddressConvertor;
import com.jpaa.mastercard.mc.services.model.Page;

@Service
public class AddressService implements IAddressService {

	private McAddressRepository addressRepository;

	public AddressService(McAddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	@Override
	public Address createAddress(Address address) {
		McAddress mcAddress = addressRepository.save(AddressConvertor.toMcAddress(address));
		return AddressConvertor.toAddress(mcAddress);
	}

	@Override
	public Address getAddress(Long addressId) {
		McAddress mcAddress = addressRepository.findById(addressId)
				.orElseThrow(() -> new AddressNotFoundException(addressId.toString()));
		return AddressConvertor.toAddress(mcAddress);
	}

	@Override
	public Page<Address> getAddresses(Address example, Integer page, Integer recordsPerPage) {
		org.springframework.data.domain.Page<McAddress> addresses = addressRepository.findAll(
				Example.of(Optional.of(AddressConvertor.toMcAddress(example)).orElse(new McAddress())),
				PageRequest.of(page - 1, recordsPerPage));
		Page<Address> pageAddresses = new Page<>();
		pageAddresses.setTotalElements(addresses.getTotalElements());
		pageAddresses.setTotalPages(addresses.getTotalPages());
		pageAddresses.setPageSize(addresses.getNumberOfElements());
		pageAddresses.setPageNumber(addresses.getNumber() + 1);
		pageAddresses.setData(addresses.stream().map(AddressConvertor::toAddress).collect(Collectors.toList()));
		return pageAddresses;
	}

	@Override
	public void deleteAddress(Long addressId) {
		McAddress mcAddress = addressRepository.findById(addressId)
				.orElseThrow(() -> new AddressNotFoundException(addressId.toString()));
		addressRepository.delete(mcAddress);
	}

}
