package com.isofttz.familyfinance.repository;

import com.isofttz.familyfinance.entities.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget,Long> {
    List<Budget> findByUserId(String userId);

    boolean existsById(Long budgetId);

    Budget findBudgetById(Long budgetId);
}
