package com.isofttz.familyfinance.controller;


import com.isofttz.familyfinance.entities.Budget;
import com.isofttz.familyfinance.entities.Categories;
import com.isofttz.familyfinance.model.ResponseModel;
import com.isofttz.familyfinance.services.BillsServices;
import com.isofttz.familyfinance.services.BudgetServices;
import com.isofttz.familyfinance.services.CategoriesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/family-finance/api/category")
public class CategoriesController {

    @Autowired
    CategoriesServices categoriesServices;

    @PostMapping("/add")
    public ResponseModel<Categories> registerUserCategories(@RequestBody Categories categories){
        final Categories savedCategories = categoriesServices.registerUserCategories(categories);
        return new ResponseModel<>(HttpStatus.OK.value(), "Category registered successfully",savedCategories);
    }

    @PutMapping("/update")
    public ResponseModel<Categories> updateUserBudget(@RequestBody Categories categories) {
        final Categories updatedCategories = categoriesServices.updateUserCategories(categories);
        return new ResponseModel<>(HttpStatus.OK.value(), "Categories updated successfully", updatedCategories);
    }

    @GetMapping("/getCategories/{userId}")
    public ResponseModel<List<Categories>> getUserBudget(@PathVariable(name = "userId") String userId){
        final List<Categories> savedCategories = categoriesServices.getAllCategoriesByUserId(userId);

        if(savedCategories.isEmpty()){
            return new ResponseModel<>(HttpStatus.NOT_FOUND.value(),"Categories not found",savedCategories);
        }else{
            return new ResponseModel<>(HttpStatus.OK.value(), "Categories found successfully",savedCategories);
        }
    }

    @PostMapping("/deleteCategories/{catId}")
    public ResponseModel<Boolean> deleteUserBudgetById(@PathVariable(name = "catId") Long catId){
        final Boolean deleted = categoriesServices.deleteUserCategoriesById(catId);
        return new ResponseModel<>(HttpStatus.OK.value(), "Categories deleted successfully", deleted);
    }


    @GetMapping("/getCategoriesById/{catId}")
    public ResponseModel<Categories> findUserBudgetById(@PathVariable(name = "catId") Long catId){
        final Categories categories = categoriesServices.findCategoriesById(catId);
        return new ResponseModel<>(HttpStatus.OK.value(), "Categories found successfully", categories);
    }

}
