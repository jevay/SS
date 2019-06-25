package com.starter.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.starter.demo.entity.MoneyPO;

public interface MoneyUpdateRepository extends CrudRepository<MoneyPO, Integer> {

}
