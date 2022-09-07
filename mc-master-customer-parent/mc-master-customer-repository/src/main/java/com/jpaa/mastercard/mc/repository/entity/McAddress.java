package com.jpaa.mastercard.mc.repository.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class McAddress extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", updatable = false)
	private McCustomer customer;

	private String street;

	private String state;

	private String country;

	private String zipCode;

	@Enumerated(EnumType.STRING)
	private McAddressType addressType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public McCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(McCustomer customer) {
		this.customer = customer;
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

	public McAddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(McAddressType addressType) {
		this.addressType = addressType;
	}

	@Override
	public String toString() {
		return "McAddress [id=" + id + ", customer=" + customer + ", street=" + street + ", state=" + state
				+ ", country=" + country + ", zipCode=" + zipCode + ", addressType=" + addressType + "]";
	}

}
