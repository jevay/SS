package com.starter.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starter.demo.service.JPAInsertDemo;
import com.starter.demo.service.JPAUpdateDemo;

@RestController
@RequestMapping(value="/money")
public class MoneyController {
	@Autowired
	private JPAInsertDemo insertDemo;
	
	@Autowired
	private JPAUpdateDemo updateDemo;
	
	@GetMapping(value="/get")
	public void testInsert() {
		insertDemo.testInsert();
	}
	
	@GetMapping(value="update")
	public void testUpdate() {
		updateDemo.testUpdate();
	}
}
