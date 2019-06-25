package com.starter.demo.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.starter.demo.entity.MoneyPO;
import com.starter.demo.repo.MoneyCreateRepository;

@Component
public class JPAInsertDemo {
	@Autowired
	private MoneyCreateRepository mcr;
	
	public void testInsert() {
		addOne();
//		addMultl();
	}

	private void addOne() {
		MoneyPO money = new MoneyPO();
		money.setName("RMB");
		money.setMoney(1000L);
		money.setIsDeleted((byte) 0x00);
		Timestamp now = new Timestamp(System.currentTimeMillis());
		
		money.setCreateAt(now);
		money.setUpdateAt(now);
		MoneyPO res = mcr.save(money);
		System.out.println("after insert res: " + res);
	}
}
