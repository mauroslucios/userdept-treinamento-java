package com.spring.userdept.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.userdept.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
