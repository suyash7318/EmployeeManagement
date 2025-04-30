package com.platformcommons.employeemanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.platformcommons.employeemanagement.entity.Department;
import com.platformcommons.employeemanagement.entity.Employee;
import com.platformcommons.employeemanagement.repository.DepartmentRepository;
import com.platformcommons.employeemanagement.service.impl.DepartmentServiceImpl;
import com.platformcommons.employeemanagement.service.impl.EmployeeServiceImpl;

@RestController
public class DepartmentController 
{

    private final DepartmentRepository departmentRepository;
	@Autowired
    private DepartmentServiceImpl departmentService;
	@Autowired
	private EmployeeServiceImpl empServiceImpl;


    DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    
    @PostMapping("/adddepartment/{id}")
    public void addDepartment(@RequestBody Department department, @PathVariable Long id) {
        Employee employee = empServiceImpl.getEmployeeById(id);
        department.getEmployees().add(employee);
        employee.getDepartment().add(department); 

        departmentService.addDepartment(department);
    }


    @GetMapping("/viewdepartment")
    public  List<Department> getAllDepartment() {
        return departmentService.getAllDepartment();
    }

    @GetMapping("/viewdepartmentbyid/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/updatedepartment/{id}")
    public Department updateEmployee(@PathVariable Long id, @RequestBody Department dept) {
      Department department = departmentService.getDepartmentById(id);
      department.setId(id);
      department.setDepartmentName(dept.getDepartmentName());
      departmentService.addDepartment(department);
      return department;
    }

    @DeleteMapping("/deletedepartment/{id}")
    public void deleteDepartment(@PathVariable Long id) {
    	departmentService.deleteDepartment(id);
    }
	
}