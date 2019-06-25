package com.starter.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.demo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
