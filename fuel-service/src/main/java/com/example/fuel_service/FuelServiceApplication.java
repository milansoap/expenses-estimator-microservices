package com.example.fuel_service;

import com.example.fuel_service.services.FuelPriceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FuelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuelServiceApplication.class, args);
		FuelPriceService fuelPriceService = new FuelPriceService();
		System.out.println(fuelPriceService.getFuelPriceByCountry("Spain"));
	}

}
