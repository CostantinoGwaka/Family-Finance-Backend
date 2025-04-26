package com.isofttz.familyfinance.controller;


import com.isofttz.familyfinance.entities.Budget;
import com.isofttz.familyfinance.model.ResponseModel;
import com.isofttz.familyfinance.services.BillsServices;
import com.isofttz.familyfinance.services.BudgetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budget")
public class BudgetController {

    @Autowired
    BudgetServices budgetServices;

    @PostMapping("/add")
    public ResponseModel<Budget> registerUserBudget(@RequestBody Budget budget){
        final Budget savedBudget = budgetServices.registerUserBudget(budget);
        return new ResponseModel<>(HttpStatus.OK.value(), "Budget registered successfully",savedBudget);
    }

    @PutMapping("/update")
    public ResponseModel<Budget> updateUserBudget(@RequestBody Budget budget) {
        final Budget updatedBudget = budgetServices.updateUserBudget(budget);
        return new ResponseModel<>(HttpStatus.OK.value(), "Budget updated successfully", updatedBudget);
    }

    @GetMapping("/getBudget/{userId}")
    public ResponseModel<List<Budget>> getUserBudget(@PathVariable(name = "userId") String userId){
        final List<Budget> savedBudget = budgetServices.getAllBudgetByUserId(userId);

        if(savedBudget.isEmpty()){
            return new ResponseModel<>(HttpStatus.NOT_FOUND.value(),"Budget not found",savedBudget);
        }else{
            return new ResponseModel<>(HttpStatus.OK.value(), "Budget found successfully",savedBudget);
        }
    }

    @PostMapping("/deleteBudget/{budgetId}")
    public ResponseModel<Boolean> deleteUserBudgetById(@PathVariable(name = "budgetId") Long budgetId){
        final Boolean deleted = budgetServices.deleteUserBudgetById(budgetId);
        return new ResponseModel<>(HttpStatus.OK.value(), "budget deleted successfully", deleted);
    }


    @GetMapping("/getBudgetById/{budgetId}")
    public ResponseModel<Budget> findUserBudgetById(@PathVariable(name = "budgetId") Long budgetId){
        final Budget budget = budgetServices.findBudgetById(budgetId);
        return new ResponseModel<>(HttpStatus.OK.value(), "budget found successfully", budget);
    }

}
