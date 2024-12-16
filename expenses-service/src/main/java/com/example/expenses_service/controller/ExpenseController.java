package com.example.expenses_service.controller;

import com.example.expenses_service.services.ExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // WE RETURN ONLYT DIESEL PRICE FOR NOW
    @GetMapping("/api/get-fuel-price-for-country")
    public double calculateExpenses(@RequestParam String country) {
        return expenseService.calculateExpenses(country);
    }

    @GetMapping("/api/get-fuel-price-for-country/{country}")
    public double getFuelPriceForCountry(@PathVariable String country) {
        return expenseService.calculateExpenses(country);
    }

    @GetMapping("/api/get-toll-price/{from}/{to}")
    public double getFuelPriceForCountry(@PathVariable String from, @PathVariable String to) {
        return expenseService.calculateTolls(from, to);
    }


}
