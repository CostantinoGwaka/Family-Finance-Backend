package com.isofttz.familyfinance.servicesImpl;

import com.isofttz.familyfinance.entities.Transactions;
import com.isofttz.familyfinance.model.ApiException;
import com.isofttz.familyfinance.repository.AppUserRepository;
import com.isofttz.familyfinance.repository.TransactionsRepository;
import com.isofttz.familyfinance.services.TransactionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionsServiceImpl implements TransactionsServices {
    @Autowired
    TransactionsRepository transactionsRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public Transactions registerUserTransaction(Transactions transaction) {

        Transactions savedTransactions;

        final boolean doesUserExist = appUserRepository.existsById(Long.valueOf(transaction.getUserId()));

        if (!doesUserExist) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "User not found!");
        }

        savedTransactions = transactionsRepository.save(transaction);
        return savedTransactions;

    }

    @Override
    public Transactions updateUserTransaction(Transactions transaction) {

        Transactions updateUserTransaction;

        final boolean doesCategoryExist = transactionsRepository.existsById(transaction.getId());

        if (!doesCategoryExist) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Transaction not found!");
        }

        updateUserTransaction = transactionsRepository.save(transaction);
        return updateUserTransaction;

    }

    @Override
    public List<Transactions> getAllTransactionsByUserId(String userId) {
        List<Transactions> incomes = transactionsRepository.findByUserId(userId);

        if (incomes.isEmpty()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "User Transaction not found");
        }

        return incomes;
    }

    @Override
    public Boolean deleteUserTransactionById(Long incomeId) {
        final Boolean transactionExists = transactionsRepository.existsById(incomeId);

        if(!transactionExists){
            throw new ApiException(HttpStatus.BAD_REQUEST, "Transaction not found");
        }

        if (transactionsRepository.existsById(incomeId)) {
            transactionsRepository.deleteById(incomeId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Transactions findTransactionsById(Long transactionId) {
        return transactionsRepository.findTransactionsById(transactionId);
    }
}
