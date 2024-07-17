package com.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.demo.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

}
