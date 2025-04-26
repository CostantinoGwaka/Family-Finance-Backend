package com.isofttz.familyfinance.repository;

import com.isofttz.familyfinance.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Categories,Long> {

    List<Categories> findByUserId(String userId);

    boolean existsById(Long catId);

    boolean existsByNameAndUserId(String name, String userId);

    Categories findCategoriesById(Long catId);

}
