package com.isofttz.familyfinance.services;

import com.isofttz.familyfinance.entities.Categories;
import com.isofttz.familyfinance.entities.Income;

import java.util.List;

public interface IncomeServices {

    Income registerUserIncome(Income income);

    Income updateUserIncome(Income income);

    List<Income> getAllIncomeByUserId(String userId);

    Boolean deleteUserIncomeById(Long incomeId);

    Income findIncomeById(Long incomeId);
}
