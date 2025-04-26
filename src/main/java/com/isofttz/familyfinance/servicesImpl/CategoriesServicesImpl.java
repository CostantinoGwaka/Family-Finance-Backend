package com.isofttz.familyfinance.servicesImpl;

import com.isofttz.familyfinance.entities.Budget;
import com.isofttz.familyfinance.entities.Categories;
import com.isofttz.familyfinance.model.ApiException;
import com.isofttz.familyfinance.repository.AppUserRepository;
import com.isofttz.familyfinance.repository.BudgetRepository;
import com.isofttz.familyfinance.repository.CategoriesRepository;
import com.isofttz.familyfinance.services.CategoriesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServicesImpl implements CategoriesServices {


    @Autowired
    CategoriesRepository categoriesRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public Categories registerUserCategories(Categories categories) {

        Categories savedCategory;

        final boolean doesUserExist = appUserRepository.existsById(Long.valueOf(categories.getUserId()));

        if (!doesUserExist) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "User not found!");
        }

        final boolean isFoundedCategoryNameAndUserId = categoriesRepository.existsByNameAndUserId(categories.getName(), categories.getUserId());

        if(isFoundedCategoryNameAndUserId){
            throw new ApiException(HttpStatus.BAD_REQUEST, "Fail to add User has same category name");
        }

        savedCategory = categoriesRepository.save(categories);
        return savedCategory;

    }

    @Override
    public Categories updateUserCategories(Categories categories) {

        Categories updateUserCategories;

        final boolean doesCategoryExist = categoriesRepository.existsById(categories.getId());

        if (!doesCategoryExist) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Category not found!");
        }

        updateUserCategories = categoriesRepository.save(categories);
        return updateUserCategories;

    }

    @Override
    public List<Categories> getAllCategoriesByUserId(String userId) {
        List<Categories> categories = categoriesRepository.findByUserId(userId);

        if (categories.isEmpty()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "User Budget not found");
        }

        return categories;
    }

    @Override
    public Boolean deleteUserCategoriesById(Long catId) {
        final Boolean catExists = categoriesRepository.existsById(catId);

        if(!catExists){
            throw new ApiException(HttpStatus.BAD_REQUEST, "Category not found");
        }

        if (categoriesRepository.existsById(catId)) {
            categoriesRepository.deleteById(catId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Categories findCategoriesById(Long catId) {
        return categoriesRepository.findCategoriesById(catId);
    }
}
