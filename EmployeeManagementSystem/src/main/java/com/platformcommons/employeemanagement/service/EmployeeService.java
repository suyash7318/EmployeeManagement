package com.platformcommons.employeemanagement.service;

import java.util.List;

import com.platformcommons.employeemanagement.entity.Employee;

public interface EmployeeService 
{
	Employee addEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(Long id);
	boolean deleteEmployee(Long id);
}