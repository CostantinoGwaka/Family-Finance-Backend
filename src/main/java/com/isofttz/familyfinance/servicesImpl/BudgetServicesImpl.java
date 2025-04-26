package com.isofttz.familyfinance.servicesImpl;

import com.isofttz.familyfinance.entities.Budget;
import com.isofttz.familyfinance.model.ApiException;
import com.isofttz.familyfinance.repository.AppUserRepository;
import com.isofttz.familyfinance.repository.BudgetRepository;
import com.isofttz.familyfinance.services.BudgetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServicesImpl implements BudgetServices {


    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public Budget registerUserBudget(Budget budget) {

        Budget savedBills;

        final boolean doesUserExist = appUserRepository.existsById(Long.valueOf(budget.getUserId()));

        if (!doesUserExist) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "User not found!");
        }

        savedBills = budgetRepository.save(budget);
        return savedBills;

    }

    @Override
    public Budget updateUserBudget(Budget budget) {

        Budget updateUserBudget;

        final boolean doesBudgetExist = budgetRepository.existsById(budget.getId());

        if (!doesBudgetExist) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Budget not found!");
        }

        updateUserBudget = budgetRepository.save(budget);
        return updateUserBudget;

    }

    @Override
    public List<Budget> getAllBudgetByUserId(String userId) {
        List<Budget> budgets = budgetRepository.findByUserId(userId);

        if (budgets.isEmpty()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "User Budget not found");
        }

        return budgets;
    }

    @Override
    public Boolean deleteUserBudgetById(Long budgetId) {
        final Boolean billExists = budgetRepository.existsById(budgetId);

        if(!billExists){
            throw new ApiException(HttpStatus.BAD_REQUEST, "Budget not found");
        }

        if (budgetRepository.existsById(budgetId)) {
            budgetRepository.deleteById(budgetId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Budget findBudgetById(Long budgetId) {
        return budgetRepository.findBudgetById(budgetId);
    }
}
