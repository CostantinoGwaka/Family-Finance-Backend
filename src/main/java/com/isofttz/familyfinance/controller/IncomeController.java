package com.isofttz.familyfinance.controller;

import com.isofttz.familyfinance.entities.Income;
import com.isofttz.familyfinance.model.ResponseModel;
import com.isofttz.familyfinance.services.IncomeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @Autowired
    IncomeServices incomeServices;

    @PostMapping("/add")
    public ResponseModel<Income> registerUserCategories(@RequestBody Income income){
        final Income savedIncome = incomeServices.registerUserIncome(income);
        return new ResponseModel<>(HttpStatus.OK.value(), "Income registered successfully",savedIncome);
    }

    @PutMapping("/update")
    public ResponseModel<Income> updateUserIncome(@RequestBody Income income) {
        final Income updatedIncome = incomeServices.updateUserIncome(income);
        return new ResponseModel<>(HttpStatus.OK.value(), "Income updated successfully", updatedIncome);
    }

    @GetMapping("/getIncome/{userId}")
    public ResponseModel<List<Income>> getUserIncome(@PathVariable(name = "userId") String userId){
        final List<Income> savedIncome = incomeServices.getAllIncomeByUserId(userId);

        if(savedIncome.isEmpty()){
            return new ResponseModel<>(HttpStatus.NOT_FOUND.value(),"Income not found",savedIncome);
        }else{
            return new ResponseModel<>(HttpStatus.OK.value(), "Income found successfully",savedIncome);
        }
    }

    @PostMapping("/deleteIncome/{incomeId}")
    public ResponseModel<Boolean> deleteUserIncomeById(@PathVariable(name = "incomeId") Long incomeId){
        final Boolean deleted = incomeServices.deleteUserIncomeById(incomeId);
        return new ResponseModel<>(HttpStatus.OK.value(), "Income deleted successfully", deleted);
    }


    @GetMapping("/getIncomeById/{incomeId}")
    public ResponseModel<Income> findUserIncomeById(@PathVariable(name = "incomeId") Long Income){
        final Income incomes = incomeServices.findIncomeById(Income);
        return new ResponseModel<>(HttpStatus.OK.value(), "Income found successfully", incomes);
    }

}
