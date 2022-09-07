package com.jpaa.mastercard.mc.repository.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class McCustomer extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	private String lastName;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "customerId", insertable = false, updatable = false)
	private List<McAddress> addresses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<McAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<McAddress> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "McCustomer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", addresses="
				+ addresses + "]";
	}

}
