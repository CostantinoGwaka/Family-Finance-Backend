package com.isofttz.familyfinance.entities;

import lombok.Data;

@Data
public class ExpenseDTO {
    private Long id;
    private String userId;
    private Long amount;
    private String categoryTitle;
    private String spentOn;
    private String notes;

    public ExpenseDTO(Expenses expense) {
        this.id = expense.getId();
        this.userId = expense.getUserId();
        this.amount = expense.getAmount();
        this.spentOn = expense.getSpentOn();
        this.notes = expense.getNotes();
        this.categoryTitle = expense.getCategory().getName(); // access category safely
    }
}
