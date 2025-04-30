package com.platformcommons.employeemanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Employee Code cannot be null")
    private String employeeCode;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="emp_dept_name",joinColumns = @JoinColumn(name="emp_id"), inverseJoinColumns = @JoinColumn(name="department_id"))
    @JsonManagedReference
    private List<Department> department = new ArrayList<>();

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Address> addresses;
  
    
    public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public List<Department> getDepartment() {
		return department;
	}




	public void setDepartment(List<Department> department) {
		this.department = department;
	}




	public List<Address> getAddresses() {
		return addresses;
	}




	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}




	@Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', employeeCode='" + employeeCode + "', department=" + department + "}";
    }
}
