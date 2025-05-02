package com.isofttz.familyfinance.repository;

import com.isofttz.familyfinance.entities.Categories;
import com.isofttz.familyfinance.entities.Expenses;
import com.isofttz.familyfinance.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expenses,Long> {


    List<Expenses> findByUserId(String userId);

    boolean existsById(Long expenseId);

    Expenses findExpensesById(Long expenseId);

    @Query("SELECT SUM(t.amount) FROM Expenses t WHERE t.userId = :userId")
    Integer getTotalExpenseByUserId(@Param("userId") String userId);

    @Query("SELECT SUM(t.amount) FROM Expenses t WHERE t.userId = :userId AND t.category.type = 'expense'")
    Integer getTotalExpenseTypeByUserId(@Param("userId") String userId);

}
