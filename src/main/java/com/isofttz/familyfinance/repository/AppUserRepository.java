package com.isofttz.familyfinance.repository;

import com.isofttz.familyfinance.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByUserName(String userName);

    Boolean existsByPhone(String phone);

    Optional<Users> findByPhone(String phone);
}
