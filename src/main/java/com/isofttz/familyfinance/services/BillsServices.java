package com.isofttz.familyfinance.services;

import com.isofttz.familyfinance.entities.Bills;

import java.util.List;

public interface BillsServices {

    Bills registerUserBills(Bills bills);

    List<Bills> getAllBillByUserId(String userId);

    Boolean deleteUserBillById(Long billId);

    Bills findBillsById(Long billId);
}
