package com.isofttz.familyfinance.servicesImpl;


import com.isofttz.familyfinance.entities.Expenses;
import com.isofttz.familyfinance.entities.Income;
import com.isofttz.familyfinance.model.ApiException;
import com.isofttz.familyfinance.repository.AppUserRepository;
import com.isofttz.familyfinance.repository.ExpenseRepository;
import com.isofttz.familyfinance.repository.IncomeRepository;
import com.isofttz.familyfinance.services.ExpenseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServicesImpl implements ExpenseServices {

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public Expenses registerUserExpense(Expenses expenses) {

        Expenses savedExpenses;

        final boolean doesUserExist = appUserRepository.existsById(Long.valueOf(expenses.getUserId()));

        if (!doesUserExist) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "User not found!");
        }

        savedExpenses = expenseRepository.save(expenses);
        return savedExpenses;

    }

    @Override
    public Expenses updateUserExpense(Expenses expenses) {

        Expenses updateUserExpenses;

        final boolean doesCategoryExist = expenseRepository.existsById(expenses.getId());

        if (!doesCategoryExist) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "expenses not found!");
        }

        updateUserExpenses = expenseRepository.save(expenses);
        return updateUserExpenses;

    }

    @Override
    public List<Expenses> getAllExpenseByUserId(String userId) {
        List<Expenses> expenses = expenseRepository.findByUserId(userId);

        if (expenses.isEmpty()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "User expenses not found");
        }

        return expenses;
    }

    @Override
    public Boolean deleteUserExpenseById(Long expenseId) {
        final Boolean incomeExists = expenseRepository.existsById(expenseId);

        if(!incomeExists){
            throw new ApiException(HttpStatus.BAD_REQUEST, "expenses not found");
        }

        if (expenseRepository.existsById(expenseId)) {
            expenseRepository.deleteById(expenseId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Expenses findExpenseById(Long catId) {
        return expenseRepository.findExpensesById(catId);
    }
}
