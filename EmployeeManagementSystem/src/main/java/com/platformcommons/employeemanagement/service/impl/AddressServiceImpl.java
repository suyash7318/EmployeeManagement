package com.platformcommons.employeemanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platformcommons.employeemanagement.entity.Address;
import com.platformcommons.employeemanagement.entity.Employee;
import com.platformcommons.employeemanagement.repository.AddressRepository;

@Service
public class AddressServiceImpl 
{
	@Autowired
	private AddressRepository addressRepository;
	
	 public Address addAddress(Address address){
	        return addressRepository.save(address);  
	 }
	 
	 public List<Address> getAllAddress() {
	        return addressRepository.findAll();
	    }

	 public Address getAddressById(Long id) {
	        Optional<Address> address = addressRepository.findById(id);
	        return address.orElse(null);
	    }
	 
	 public void deleteAddress(Long id) {
		 addressRepository.deleteById(id);
	    }
}