package com.isofttz.familyfinance.repository;

import com.isofttz.familyfinance.entities.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget,Long> {
    List<Budget> findByUserId(String userId);

    boolean existsById(Long budgetId);

    Budget findBudgetById(Long budgetId);

    @Query("SELECT SUM(t.amount) FROM Budget t WHERE t.userId = :userId")
    Integer getTotalBudgetByUserId(@Param("userId") String userId);
}
