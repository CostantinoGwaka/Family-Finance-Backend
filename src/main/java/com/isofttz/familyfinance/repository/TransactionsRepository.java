package com.isofttz.familyfinance.repository;

import com.isofttz.familyfinance.entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions,Long> {
}
