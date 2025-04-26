package com.isofttz.familyfinance.repository;

import com.isofttz.familyfinance.entities.Categories;
import com.isofttz.familyfinance.entities.Expenses;
import com.isofttz.familyfinance.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expenses,Long> {



}
