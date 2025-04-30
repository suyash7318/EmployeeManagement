package com.platformcommons.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.platformcommons.employeemanagement.service.EmployeeService;

import java.util.List;

import com.platformcommons.employeemanagement.entity.Employee; 

@RestController
public class EmployeeController {

	@Autowired
    private EmployeeService employeeService;

	
    @PostMapping("/addemployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody  Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/viewemployee")
    public  List<Employee> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees;
    }

    @GetMapping("/viewemployeebyid/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    @PutMapping("/updateemployee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
      Employee emp = employeeService.getEmployeeById(id);
      emp.setId(id);
      emp.setName(employee.getName());
      employeeService.addEmployee(emp);
      return emp;
    }

    @DeleteMapping("/deleteemployee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}