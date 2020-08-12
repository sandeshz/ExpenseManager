package com.api.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.expensetracker.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
