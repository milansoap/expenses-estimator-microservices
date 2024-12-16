package com.example.fuel_service.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class FuelPriceService {

    public String getFuelPriceByCountry(String country) {
        try {
            String url = "https://www.globalpetrolprices.com/" + country.replace(" ", "_") + "/";
            Document document = Jsoup.connect(url).get();
            Element fuelPriceElement = document.selectXpath("//*[@id=\"graphPageLeft\"]/table[1]/tbody/tr[2]/td[2]").first();
            return fuelPriceElement != null ? fuelPriceElement.text() : "Data not found";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching data: " + e.getMessage();
        }
    }
}
