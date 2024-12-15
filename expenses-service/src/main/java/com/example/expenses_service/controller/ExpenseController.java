package com.example.expenses_service.controller;

import com.example.expenses_service.services.ExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

//    // WE RETURN ONLYT DIESEL PRICE FOR NOW
//    @GetMapping("/api/calculate-expenses")
//    public double calculateExpenses(@RequestParam double distance, String from, String to) {
//        return expenseService.calculateExpenses(distance);
//    }

    // WE RETURN ONLYT DIESEL PRICE FOR NOW
    @GetMapping("/api/get-fuel-price-for-country")
    public double calculateExpenses(@RequestParam String country) {
        return expenseService.calculateExpenses(country);
    }



}
