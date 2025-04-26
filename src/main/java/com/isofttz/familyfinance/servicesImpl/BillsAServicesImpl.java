package com.isofttz.familyfinance.servicesImpl;

import com.isofttz.familyfinance.entities.Bills;
import com.isofttz.familyfinance.model.ApiException;
import com.isofttz.familyfinance.model.GlobalExceptionHandler;
import com.isofttz.familyfinance.repository.AppUserRepository;
import com.isofttz.familyfinance.repository.BillsRepository;
import com.isofttz.familyfinance.services.BillsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillsAServicesImpl implements BillsServices {

    @Autowired
    BillsRepository billsRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public Bills registerUserBills(Bills bill) {

        Bills savedBills;

        final boolean doesUserExist = appUserRepository.existsById(Long.valueOf(bill.getUserId()));

        if (!doesUserExist) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "User not found!");
        }

        savedBills = billsRepository.save(bill);
        return savedBills;

    }

    @Override
    public Bills updateUserBills(Bills bill) {

        Bills updateUserBills;

        final boolean doesBillExist = billsRepository.existsById(bill.getId());

        if (!doesBillExist) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Bills not found!");
        }

        updateUserBills = billsRepository.save(bill);
        return updateUserBills;

    }

    @Override
    public List<Bills> getAllBillByUserId(String userId) {
        List<Bills> bills = billsRepository.findByUserId(userId);

        if (bills.isEmpty()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "User bills not found");
        }

        return bills;
    }

    @Override
    public Boolean deleteUserBillById(Long billId) {
        final Boolean billExists = billsRepository.existsById(billId);

        if(!billExists){
            throw new ApiException(HttpStatus.BAD_REQUEST, "bills not found");
        }

        if (billsRepository.existsById(billId)) {
            billsRepository.deleteById(billId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Bills findBillsById(Long billId) {
        return billsRepository.findBillsById(billId);
    }

}
