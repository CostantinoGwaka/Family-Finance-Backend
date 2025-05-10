package com.isofttz.familyfinance.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @GetMapping("/family-finance/test/welcome")
    public String welcome(){
        return "Welcome to finance service";
    }
}
