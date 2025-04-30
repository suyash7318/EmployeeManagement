package com.platformcommons.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.platformcommons.employeemanagement.entity.Address;
import com.platformcommons.employeemanagement.entity.Employee;
import com.platformcommons.employeemanagement.service.impl.AddressServiceImpl;
import com.platformcommons.employeemanagement.service.impl.EmployeeServiceImpl;



@RestController
public class AddressController 
{
	@Autowired
    private AddressServiceImpl addressService;
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
    @PostMapping("/addaddress/{id}")
    public void addAddress(@RequestBody  Address address,@PathVariable Long id) {
    	Employee emp = employeeServiceImpl.getEmployeeById(id);
    	address.setEmployee(emp);
    	addressService.addAddress(address);
    }

    @GetMapping("/viewaddress")
    public  List<Address> getAllAddress() {
        return addressService.getAllAddress();
    }

    @GetMapping("/viewaddressbyid/{id}")
    public Address getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    @PutMapping("/updateaddress/{id}")
    public Address updateEmployee(@PathVariable Long id, @RequestBody Address add) {
      Address address = addressService.getAddressById(id);
      address.setId(id);
      address.setCity(add.getCity());
      address.setStreet(add.getStreet());
      address.setState(add.getState());
      address.setZipCode(add.getZipCode());
      addressService.addAddress(address);
      return address;
    }

    @DeleteMapping("/deleteaddress/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}