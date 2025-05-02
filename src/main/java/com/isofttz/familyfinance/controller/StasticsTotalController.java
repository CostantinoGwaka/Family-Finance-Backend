package com.isofttz.familyfinance.controller;


import com.isofttz.familyfinance.entities.TotalSummaryDTO;
import com.isofttz.familyfinance.model.ResponseModel;
import com.isofttz.familyfinance.services.StatisticsTotalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statisticsTotal")
public class StasticsTotalController {


    @Autowired
    StatisticsTotalServices statisticsTotalServices;


    // Endpoint to get total expense for all users
//    @GetMapping("/total-expense")
//    public ResponseEntity<Integer> getTotalExpense() {
//        int total = statisticsTotalServices.getTotalExpense();
//        return ResponseEntity.ok(total);
//    }

    // Endpoint to get total expense by user ID
    @GetMapping("/total/{userId}")
    public ResponseEntity<ResponseModel<List<TotalSummaryDTO>>> getTotalByUser(@PathVariable String userId) {
        int totalExpense = statisticsTotalServices.getTotalExpenseByUser(userId);
        int totalIncome = statisticsTotalServices.getTotalIncomesByUser(userId);
        int totalBudget = statisticsTotalServices.getTotalBudgetByUser(userId);
        int totalBill = statisticsTotalServices.getTotalBudgetByUser(userId);

        List<TotalSummaryDTO> totals = List.of(
                new TotalSummaryDTO("expense", totalExpense),
                new TotalSummaryDTO("income", totalIncome),
                new TotalSummaryDTO("budget",totalBudget ),
                new TotalSummaryDTO("bills",totalBill)
        );

        ResponseModel<List<TotalSummaryDTO>> response = new ResponseModel<>(
                HttpStatus.OK.value(),
                "User totals fetched successfully",
                totals
        );

        return ResponseEntity.ok(response);
    }
}
