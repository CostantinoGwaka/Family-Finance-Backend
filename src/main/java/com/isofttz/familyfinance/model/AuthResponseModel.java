package com.isofttz.familyfinance.model;

import com.isofttz.familyfinance.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseModel {
    private int statusCode;

    private String message;

    private String accessToken;

    private Long loginTime;

    private Long expirationDuration;

    private Users userDetails;
}

