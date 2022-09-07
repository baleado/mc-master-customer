package com.jpaa.mastercard.mc.services.model;

import javax.validation.constraints.NotNull;

import com.jpaa.mastercard.mc.services.model.validator.ValidZipCode;

public class Address {

	private Long id;

	@NotNull(message = "street must not be Null")
	private String street;

	@NotNull(message = "state must not be Null")
	private String state;

	@NotNull(message = "country must not be Null")
	private String country;

	@NotNull(message = "zipCode must must not be Null")
	@ValidZipCode
	private String zipCode;

	@NotNull(message = "customerId must not be Null")
	private Long customerId;

	@NotNull(message = "addressType id must not be Null")
	private AddressType addressType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", state=" + state + ", country=" + country + ", zipCode="
				+ zipCode + ", customerId=" + customerId + ", addressType=" + addressType + "]";
	}

}
