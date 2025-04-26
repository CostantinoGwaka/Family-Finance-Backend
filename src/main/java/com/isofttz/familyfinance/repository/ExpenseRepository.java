package com.isofttz.familyfinance.repository;

import com.isofttz.familyfinance.entities.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expenses,Long> {
}
