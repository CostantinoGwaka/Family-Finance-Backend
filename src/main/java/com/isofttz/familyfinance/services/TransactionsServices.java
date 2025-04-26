package com.isofttz.familyfinance.services;

import com.isofttz.familyfinance.entities.Income;
import com.isofttz.familyfinance.entities.Transactions;

import java.util.List;

public interface TransactionsServices {

    Transactions registerUserTransaction(Transactions transactions);

    Transactions updateUserTransaction(Transactions transactions);

    List<Transactions> getAllTransactionsByUserId(String userId);

    Boolean deleteUserTransactionById(Long transactionId);

    Transactions findTransactionsById(Long transactionId);
}
