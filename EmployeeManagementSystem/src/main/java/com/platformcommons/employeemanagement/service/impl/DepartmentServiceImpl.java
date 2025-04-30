package com.platformcommons.employeemanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platformcommons.employeemanagement.entity.Address;
import com.platformcommons.employeemanagement.entity.Department;
import com.platformcommons.employeemanagement.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl 
{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department addDepartment(Department department){
        return departmentRepository.save(department);  
	 }
	 
	 public List<Department> getAllDepartment() {
	        return departmentRepository.findAll();
	    }
	
	 public Department getDepartmentById(Long id) {
	        Optional<Department> department = departmentRepository.findById(id);
	        return department.orElse(null);
	    }
	 
	 public void deleteDepartment(Long id) {
		 departmentRepository.deleteById(id);
	    }
}