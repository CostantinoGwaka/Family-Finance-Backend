package com.isofttz.familyfinance.services;

public interface StatisticsTotalServices {

    int getTotalExpenseByUser(String userId);

    int getTotalIncomeByUser(String userId);

    int getTotalIncomesByUser(String userId);

    int getTotalBudgetByUser(String userId);

    int getTotalBillByUser(String userId);

}
