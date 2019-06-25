package com.starter.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starter.demo.entity.Employee;
import com.starter.demo.service.EmployeeService;

@RestController
@RequestMapping(value="employee")
public class EmployeeController {
	@Autowired
	private EmployeeService es;
	
	@GetMapping(value="/get")
	public Employee getEmployeeByName(@RequestParam("name") String name) {
		return es.getEmployeeByName(name);
	}
	
	@PostMapping(value="/save")
	public Employee save(@RequestBody Employee employee) {
		return es.save(employee);
	}
	
	@PutMapping(value="/update")
	public void updatePassword(@RequestParam("id") String id, @RequestBody Employee employee) {
		System.out.println("Update the employee id: " + id);
		System.out.println("Update the password with: " + employee.getPassword());
		es.updatePassword(id, employee.getPassword());
	}
	
	@DeleteMapping(value="/remove")
	public void delete(@RequestParam("id") String id) {
		es.deleteById(id);
	}
}
