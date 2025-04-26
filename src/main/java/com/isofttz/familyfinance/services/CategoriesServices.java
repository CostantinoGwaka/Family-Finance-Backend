package com.isofttz.familyfinance.services;

import com.isofttz.familyfinance.entities.Categories;

import java.util.List;

public interface CategoriesServices {

    Categories registerUserCategories(Categories categories);

    Categories updateUserCategories(Categories categories);

    List<Categories> getAllCategoriesByUserId(String userId);

    Boolean deleteUserCategoriesById(Long catId);

    Categories findCategoriesById(Long catId);
}
