package com.jpaa.mastercard.mc.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaa.mastercard.mc.repository.entity.McAddress;

public interface McAddressRepository extends JpaRepository<McAddress, Long> {

}
