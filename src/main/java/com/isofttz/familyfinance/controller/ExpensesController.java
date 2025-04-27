package com.isofttz.familyfinance.controller;


import com.isofttz.familyfinance.entities.Expenses;
import com.isofttz.familyfinance.model.ResponseModel;
import com.isofttz.familyfinance.services.ExpenseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpensesController {


    @Autowired
    ExpenseServices expenseServices;

    @PostMapping("/add")
    public ResponseModel<Expenses> registerUserExpenses(@RequestBody Expenses expenses){
        final Expenses savedExpenses = expenseServices.registerUserExpense(expenses);
        return new ResponseModel<>(HttpStatus.OK.value(), "Expenses registered successfully",savedExpenses);
    }

    @PutMapping("/update")
    public ResponseModel<Expenses> updateUserExpenses(@RequestBody Expenses expenses) {
        final Expenses updatedExpenses = expenseServices.updateUserExpense(expenses);
        return new ResponseModel<>(HttpStatus.OK.value(), "Expenses updated successfully", updatedExpenses);
    }

    @GetMapping("/getExpense/{userId}")
    public ResponseModel<List<Expenses>> getUserExpenses(@PathVariable(name = "userId") String userId){
        final List<Expenses> savedExpenses = expenseServices.getAllExpenseByUserId(userId);

        if(savedExpenses.isEmpty()){
            return new ResponseModel<>(HttpStatus.NOT_FOUND.value(),"expenses not found",savedExpenses);
        }else{
            return new ResponseModel<>(HttpStatus.OK.value(), "expenses found successfully",savedExpenses);
        }
    }

    @PostMapping("/deleteExpense/{expenseId}")
    public ResponseModel<Boolean> deleteUserExpensesById(@PathVariable(name = "expenseId") Long expenseId){
        final Boolean deleted = expenseServices.deleteUserExpenseById(expenseId);
        return new ResponseModel<>(HttpStatus.OK.value(), "expenses deleted successfully", deleted);
    }


    @GetMapping("/getExpenseById/{expenseId}")
    public ResponseModel<Expenses> findUserExpensesById(@PathVariable(name = "expenseId") Long expenseId){
        final Expenses expenses = expenseServices.findExpenseById(expenseId);
        return new ResponseModel<>(HttpStatus.OK.value(), "expenses found successfully", expenses);
    }
}
