package com.isofttz.familyfinance.services;

import com.isofttz.familyfinance.entities.Expenses;

import java.util.List;

public interface ExpenseServices {

    Expenses registerUserExpense(Expenses expenses);

    Expenses updateUserExpense(Expenses expenses);

    List<Expenses> getAllExpenseByUserId(String userId);

    Boolean deleteUserExpenseById(Long expensesId);

    Expenses findExpenseById(Long expensesId);

}
