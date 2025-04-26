package com.isofttz.familyfinance.services;

import com.isofttz.familyfinance.entities.Budget;

import java.util.List;

public interface BudgetServices {

    Budget registerUserBudget(Budget budget);

    Budget updateUserBudget(Budget budget);

    List<Budget> getAllBudgetByUserId(String userId);

    Boolean deleteUserBudgetById(Long budgetId);

    Budget findBudgetById(Long budgetId);
}
