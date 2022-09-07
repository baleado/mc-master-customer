package com.jpaa.mastercard.mc.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaa.mastercard.mc.repository.entity.McCustomer;

public interface McCustomerRepository extends JpaRepository<McCustomer, Long> {

}
