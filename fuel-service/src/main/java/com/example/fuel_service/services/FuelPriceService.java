package com.example.fuel_service.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class FuelPriceService {

    public double getFuelPriceByCountry(String country) {
        double result = 0;
        try {
            String url = "https://www.globalpetrolprices.com/" + country.replace(" ", "_") + "/";
            Document document = Jsoup.connect(url).get();
            Element fuelPriceElement = document.selectXpath("//*[@id=\"graphPageLeft\"]/table[1]/tbody/tr[2]/td[2]").first();
            result = Double.parseDouble(fuelPriceElement.text());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }
}
