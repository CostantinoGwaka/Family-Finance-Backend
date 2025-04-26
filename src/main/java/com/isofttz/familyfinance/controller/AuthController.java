package com.isofttz.familyfinance.controller;

import com.isofttz.familyfinance.entities.Users;
import com.isofttz.familyfinance.model.AuthResponseModel;
import com.isofttz.familyfinance.model.ResponseModel;
import com.isofttz.familyfinance.security.JwtTokenProvider;
import com.isofttz.familyfinance.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Value("${app.jwt-expiration-milliseconds}")
    private Long expiration;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserServices userServices;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseModel> login(@RequestBody Users user){
        final AuthResponseModel authResponseModel;
        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUserName(),user.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token =jwtTokenProvider.generateToken(authentication);
        authResponseModel =new AuthResponseModel(
                HttpStatus.OK.value(),
                "Succesfully logged in",
                token,
                System.currentTimeMillis(),
                expiration
        );
        return ResponseEntity.ok(authResponseModel);

    }

    @PostMapping("/register")
    public ResponseModel<Users> registerUser(@RequestBody Users users){
        final Users savedUser = userServices.registerUser(users);
        return new ResponseModel<>(HttpStatus.OK.value(), "user registered successfully",savedUser);
    }


}
