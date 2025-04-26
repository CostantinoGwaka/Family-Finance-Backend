package com.isofttz.familyfinance.controller;


import com.isofttz.familyfinance.entities.Bills;
import com.isofttz.familyfinance.model.ResponseModel;
import com.isofttz.familyfinance.services.BillsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillsController {

    @Autowired
    BillsServices billsServices;

    @PostMapping("/add")
    public ResponseModel<Bills> registerUserBills(@RequestBody Bills bills){
        final Bills savedBills = billsServices.registerUserBills(bills);
        return new ResponseModel<>(HttpStatus.OK.value(), "bills registered successfully",savedBills);
    }

    @GetMapping("/getBills/{userId}")
    public ResponseModel<List<Bills>> getUserBills(@PathVariable(name = "userId") String userId){
        final List<Bills> savedBills = billsServices.getAllBillByUserId(userId);

        if(savedBills.isEmpty()){
            return new ResponseModel<>(HttpStatus.NOT_FOUND.value(),"bills not found",savedBills);
        }else{
            return new ResponseModel<>(HttpStatus.OK.value(), "bills found successfully",savedBills);
        }
    }

    @PostMapping("/deleteBills/{billId}")
    public ResponseModel<Boolean> deleteUserBillsById(@PathVariable(name = "billId") Long billId){
        final Boolean deleted = billsServices.deleteUserBillById(billId);
        return new ResponseModel<>(HttpStatus.OK.value(), "bills deleted successfully", deleted);
    }


    @GetMapping("/getBillsById/{billId}")
    public ResponseModel<Bills> findUserBillsById(@PathVariable(name = "billId") Long billId){
        final Bills bills = billsServices.findBillsById(billId);
        return new ResponseModel<>(HttpStatus.OK.value(), "bills found successfully", bills);
    }

}
