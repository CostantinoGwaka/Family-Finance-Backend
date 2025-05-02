package com.isofttz.familyfinance.repository;

import com.isofttz.familyfinance.entities.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BillsRepository extends JpaRepository<Bills,Long> {

    List<Bills> findByUserId(String userId);

    boolean existsById(Long billId);

    Bills findBillsById(Long billId);

    @Query("SELECT SUM(t.amount) FROM Bills t WHERE t.userId = :userId")
    Integer getTotalBillsByUserId(@Param("userId") String userId);

}
