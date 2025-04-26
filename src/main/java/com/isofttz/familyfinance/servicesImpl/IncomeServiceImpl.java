package com.isofttz.familyfinance.servicesImpl;

import com.isofttz.familyfinance.entities.Income;
import com.isofttz.familyfinance.model.ApiException;
import com.isofttz.familyfinance.repository.AppUserRepository;
import com.isofttz.familyfinance.repository.IncomeRepository;
import com.isofttz.familyfinance.services.IncomeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeServices {

    @Autowired
    IncomeRepository incomeRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public Income registerUserIncome(Income income) {

        Income savedIncome;

        final boolean doesUserExist = appUserRepository.existsById(Long.valueOf(income.getUserId()));

        if (!doesUserExist) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "User not found!");
        }

        savedIncome = incomeRepository.save(income);
        return savedIncome;

    }

    @Override
    public Income updateUserIncome(Income income) {

        Income updateUserIncome;

        final boolean doesCategoryExist = incomeRepository.existsById(income.getId());

        if (!doesCategoryExist) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Income not found!");
        }

        updateUserIncome = incomeRepository.save(income);
        return updateUserIncome;

    }

    @Override
    public List<Income> getAllIncomeByUserId(String userId) {
        List<Income> incomes = incomeRepository.findByUserId(userId);

        if (incomes.isEmpty()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "User Incomes not found");
        }

        return incomes;
    }

    @Override
    public Boolean deleteUserIncomeById(Long incomeId) {
        final Boolean incomeExists = incomeRepository.existsById(incomeId);

        if(!incomeExists){
            throw new ApiException(HttpStatus.BAD_REQUEST, "Income not found");
        }

        if (incomeRepository.existsById(incomeId)) {
            incomeRepository.deleteById(incomeId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Income findIncomeById(Long catId) {
        return incomeRepository.findIncomeById(catId);
    }
}
