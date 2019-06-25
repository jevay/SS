package com.starter.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starter.demo.entity.Employee;
import com.starter.demo.repo.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository er;
	
	public Employee save(Employee employee) {
		return er.save(employee);
	}
	
	public Employee getEmployeeByName(String name) {
		return er.findByName(name);
	}
	
	public Employee updatePassword(String id, String password) {
		Employee employee = er.findById(Long.parseLong(id)).get();
		employee.setPassword(password);
		return er.save(employee);
	}
	
	public void deleteById(String id) {
		Employee employee = er.findById(Long.parseLong(id)).get();
		er.delete(employee);
	}
}
