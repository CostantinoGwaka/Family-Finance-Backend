package com.isofttz.familyfinance.repository;

import com.isofttz.familyfinance.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Long> {

    List<Income> findByUserId(String userId);

    boolean existsById(Long incomeId);

    Income findIncomeById(Long catId);
}
