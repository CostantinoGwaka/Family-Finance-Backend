package com.isofttz.familyfinance.services;

import com.isofttz.familyfinance.entities.Expenses;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseServices {

    Expenses registerUserExpense(Expenses expenses);

    Expenses updateUserExpense(Expenses expenses);

    List<Expenses> getAllExpenseByUserId(String userId);

    Boolean deleteUserExpenseById(Long expensesId);

//    Expenses findExpenseById(Long expensesId);
    @Query("SELECT e FROM Expenses e JOIN FETCH e.category WHERE e.id = :expensesId")
    Expenses findExpenseById(@Param("expensesId") Long expensesId);

}
