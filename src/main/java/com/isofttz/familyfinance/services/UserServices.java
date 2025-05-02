package com.isofttz.familyfinance.services;

import com.isofttz.familyfinance.entities.Users;

import java.util.List;
import java.util.Optional;

public interface UserServices {

    Users registerUser(Users users);

    List<Users> getAllRegisteredUser();

    Optional<Users> findByPhone(String phoneNumber);

    Optional<Users>  findByUserName(String phoneNumber);

}
