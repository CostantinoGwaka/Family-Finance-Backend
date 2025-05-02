package com.isofttz.familyfinance.repository;

import com.isofttz.familyfinance.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Long> {

    List<Income> findByUserId(String userId);

    boolean existsById(Long incomeId);

    Income findIncomeById(Long catId);

    @Query("SELECT SUM(t.amount) FROM Income t WHERE t.userId = :userId")
    Integer getTotalIncomeByUserId(@Param("userId") String userId);
}
