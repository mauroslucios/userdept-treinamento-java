package com.spring.userdept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.userdept.model.User;
public interface UserRepository extends JpaRepository<User, Long>{

}
