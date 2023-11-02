package com.employeemgmntapp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemgmntapp.Employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
