package com.isofttz.familyfinance.repository;

import com.isofttz.familyfinance.entities.Income;
import com.isofttz.familyfinance.entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions,Long> {

    List<Transactions> findByUserId(String userId);

    boolean existsById(Long incomeId);

    Transactions findTransactionsById(Long transactionId);
}
