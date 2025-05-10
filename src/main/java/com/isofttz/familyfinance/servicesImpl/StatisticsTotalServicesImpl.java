package com.isofttz.familyfinance.servicesImpl;

import com.isofttz.familyfinance.repository.BillsRepository;
import com.isofttz.familyfinance.repository.BudgetRepository;
import com.isofttz.familyfinance.repository.ExpenseRepository;
import com.isofttz.familyfinance.repository.IncomeRepository;
import com.isofttz.familyfinance.services.StatisticsTotalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatisticsTotalServicesImpl implements StatisticsTotalServices {

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    IncomeRepository incomeRepository;

    @Autowired
    BudgetRepository budgetRepository;

    @Autowired
    BillsRepository billsRepository;

    @Override
    public int getTotalExpenseByUser(String userId) {
        Integer total = expenseRepository.getTotalExpenseByUserId(userId);
        return total != null ? total : 0;
    }

    @Override
    public int getTotalIncomeByUser(String userId) {
        Integer total = expenseRepository.getTotalIncomeByUserId(userId);
        return total != null ? total : 0;
    }

    @Override
    public int getTotalIncomesByUser(String userId) {
        Integer total = incomeRepository.getTotalIncomeByUserId(userId);
        return total != null ? total : 0;
    }

    @Override
    public int getTotalBudgetByUser(String userId) {
        Integer total = budgetRepository.getTotalBudgetByUserId(userId);
        return total != null ? total : 0;
    }

    @Override
    public int getTotalBillByUser(String userId) {
        Integer total = billsRepository.getTotalBillsByUserId(userId);
        return total != null ? total : 0;
    }


}
