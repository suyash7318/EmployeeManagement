package com.platformcommons.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platformcommons.employeemanagement.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}