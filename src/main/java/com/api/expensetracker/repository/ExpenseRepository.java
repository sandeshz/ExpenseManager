package com.api.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.expensetracker.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

}
