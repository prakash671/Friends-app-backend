package com.employee.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.employee.management.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	

}
