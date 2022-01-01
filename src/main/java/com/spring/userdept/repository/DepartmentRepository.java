package com.spring.userdept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.userdept.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
