package com.starter.demo.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.starter.demo.entity.MoneyPO;
import com.starter.demo.repo.MoneyUpdateRepository;

@Component
public class JPAUpdateDemo {
	@Autowired
	private MoneyUpdateRepository mur;
	
	public void testUpdate() {
		MoneyPO record = mur.findById(34).get();
		
		record.setMoney(3000L);
		Timestamp now = new Timestamp(System.currentTimeMillis());
		record.setUpdateAt(now);
		mur.save(record);
		
		record = mur.findById(34).get();
		System.out.println("after update money record: " + record);
		
		record.setName("$");
		record.setMoney(6666L);
		mur.save(record);
		
		record = mur.findById(34).get();
		System.out.println("after update money with null record: " + record);
	}
}
