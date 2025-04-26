package com.isofttz.familyfinance.repository;

import com.isofttz.familyfinance.entities.Bills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillsRepository extends JpaRepository<Bills,Long> {
}
