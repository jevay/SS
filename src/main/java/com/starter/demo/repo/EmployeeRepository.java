package com.starter.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee findByName(String name);
	
}
