package com.isofttz.familyfinance.repository;

import com.isofttz.familyfinance.entities.Bills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillsRepository extends JpaRepository<Bills,Long> {

    List<Bills> findByUserId(String userId);

    boolean existsById(Long billId);

    Bills findBillsById(Long billId);

}
