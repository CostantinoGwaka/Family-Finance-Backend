package com.isofttz.familyfinance.repository;

import com.isofttz.familyfinance.entities.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget,Long> {
}
