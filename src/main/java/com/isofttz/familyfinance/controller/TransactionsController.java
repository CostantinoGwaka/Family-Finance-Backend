package com.isofttz.familyfinance.controller;

import com.isofttz.familyfinance.entities.Income;
import com.isofttz.familyfinance.entities.Transactions;
import com.isofttz.familyfinance.model.ResponseModel;
import com.isofttz.familyfinance.services.IncomeServices;
import com.isofttz.familyfinance.services.TransactionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/family-finance/api/transactions")
public class TransactionsController {

    @Autowired
    TransactionsServices transactionsServices;

    @PostMapping("/add")
    public ResponseModel<Transactions> registerUserCategories(@RequestBody Transactions transactions){
        final Transactions savedTransaction = transactionsServices.registerUserTransaction(transactions);
        return new ResponseModel<>(HttpStatus.OK.value(), "Transaction registered successfully",savedTransaction);
    }

    @PutMapping("/update")
    public ResponseModel<Transactions> updateUserIncome(@RequestBody Transactions transactions) {
        final Transactions updatedTransactions = transactionsServices.updateUserTransaction(transactions);
        return new ResponseModel<>(HttpStatus.OK.value(), "Transactions updated successfully", updatedTransactions);
    }

    @GetMapping("/getTransaction/{userId}")
    public ResponseModel<List<Transactions>> getUserIncome(@PathVariable(name = "userId") String userId){
        final List<Transactions> savedTransactions = transactionsServices.getAllTransactionsByUserId(userId);

        if(savedTransactions.isEmpty()){
            return new ResponseModel<>(HttpStatus.NOT_FOUND.value(),"Transactions not found",savedTransactions);
        }else{
            return new ResponseModel<>(HttpStatus.OK.value(), "Transactions found successfully",savedTransactions);
        }
    }

    @PostMapping("/deleteTransactions/{transactionId}")
    public ResponseModel<Boolean> deleteUserTransactionById(@PathVariable(name = "transactionId") Long transactionId){
        final Boolean deleted = transactionsServices.deleteUserTransactionById(transactionId);
        return new ResponseModel<>(HttpStatus.OK.value(), "Transaction deleted successfully", deleted);
    }


    @GetMapping("/getTransactionById/{transactionId}")
    public ResponseModel<Transactions> findUserTransactionById(@PathVariable(name = "transactionId") Long transactionId){
        final Transactions transactions = transactionsServices.findTransactionsById(transactionId);
        return new ResponseModel<>(HttpStatus.OK.value(), "Transactions found successfully", transactions);
    }

}
