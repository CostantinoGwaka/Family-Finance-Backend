package com.isofttz.familyfinance.services;

import com.isofttz.familyfinance.entities.Users;

import java.util.List;

public interface UserServices {

    Users registerUser(Users users);

    List<Users> getAllRegisteredUser();

}
