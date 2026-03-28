package com.example.swaggerdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.swaggerdemo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
