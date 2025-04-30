package com.platformcommons.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platformcommons.employeemanagement.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}