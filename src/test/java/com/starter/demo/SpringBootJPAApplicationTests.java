package com.starter.demo;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.starter.demo.entity.Role;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJPAApplicationTests {
	@Autowired
	DataSourceProperties datasourceProperties;
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Resource(name="myDataSource")
	private DataSource myDataSource;
	
	@PersistenceContext(unitName="entityManagerFactoryPrimary")
	private EntityManager entityManager;
	
	@Test
	public void testContextLoads() {
		System.out.println("Data soruce is: " + myDataSource);
		System.out.println(myDataSource.getClass().getName());
		System.out.println(datasourceProperties);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(myDataSource);
		List<?> resultList = jdbcTemplate.queryForList("select * from user_info");
		System.out.println("===>>>>>>>>" + JSON.toJSONString(resultList));
	}
	
	@Test
	@Rollback(false)
	@Transactional("transactionManagerPrimary")
	public void test() {
		Role role = new Role();
		role.setRoleName("manager");
		role.setDepartmentId(88);
		role.setStatus(12);
		entityManager.merge(role);
		entityManager.flush();
	}
	
	public void saveEmployee() {
		
	}

}
