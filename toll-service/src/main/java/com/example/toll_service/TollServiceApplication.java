package com.example.toll_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import services.TollService;

@SpringBootApplication
public class TollServiceApplication {

	public static void main(String[] args) {
//		SpringApplication.run(TollServiceApplication.class, args);

		TollService tollService = new TollService();
		double tollPrice = tollService.getTollPriceForTrip("madrid", "rome");
		System.out.println(tollPrice);

	}


}
