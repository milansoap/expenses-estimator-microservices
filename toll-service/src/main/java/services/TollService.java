package services;

import com.microsoft.playwright.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TollService {

    public double getTollPriceForTrip(String inputLocation, String outputLocation) {
        List<String> optionsText = new ArrayList<>();
        double result = 0;

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
            Page page = browser.newPage();
            page.navigate("https://tollguru.com/toll-calculator-europe");

            page.locator("#headlessui-combobox-input-\\:r23R9dlaic\\:").fill(inputLocation);

            System.out.println("[DEBUG] Input location filled: " + inputLocation);
            // Wait for the dropdown to appear

            page.waitForSelector("ul[role='listbox']");
            System.out.println("[DEBUG] Dropdown options appeared.");
            page.waitForTimeout(500);
            // Fetch all list items under the dropdown
            Locator liLocator = page.locator("ul[role='listbox'] li");
            List<String> liElements = liLocator.allTextContents();
            System.out.println("[DEBUG] Retrieved " + liElements.size() + " options.");
            // Add list items to the optionsText list
            optionsText.addAll(liElements);
            // Click on the first option in the dropdown
            liLocator.first().click();
            System.out.println("[DEBUG] First option clicked.");


            // Handle Output Location
            System.out.println("[DEBUG] Second input.");
            page.locator("#headlessui-combobox-input-\\:r23R9dpaic\\:").fill(outputLocation);
            System.out.println("[DEBUG] Output location filled: " + outputLocation);

            // Wait for the output dropdown to appear
            page.waitForTimeout(800);
            page.waitForSelector("ul[role='listbox']");
            System.out.println("[DEBUG] Output dropdown options appeared.");
            page.waitForTimeout(800);

            // Fetch all list items under the output dropdown
            Locator outputLiLocator = page.locator("ul[role='listbox'] li");
            List<String> outputLiElements = outputLiLocator.allTextContents();
            System.out.println("[DEBUG] Retrieved " + outputLiElements.size() + " output options.");
            System.out.println("[DEBUG] OVDE GLEDAJ MILANE " + outputLiElements + " output options.");

            // Add output list items to the optionsText list
            optionsText.addAll(outputLiElements);

            // Click on the first output option
            outputLiLocator.first().click();
            System.out.println("[DEBUG] First output option clicked.");

            page.waitForSelector("button:has-text('Submit'):not([disabled])");

            // Click on the Submit button
            page.locator("button:has-text('Submit')").click();

            System.out.println("[DEBUG] Button located and clicked.");

            page.waitForTimeout(7000);

            // Retrieve and log the desired value using XPath
            String xpathSelector = "//*[@id=\"info-child\"]/div/div[4]/table/tbody/tr/td[1]";
            try {
                String resultValue = page.locator(xpathSelector).innerText(); // Get the value
                resultValue = resultValue.replace("€", "").trim(); // Remove € and any extra spaces
                result = Double.parseDouble(resultValue); // Convert to double
                System.out.println("[DEBUG] Retrieved value: " + resultValue);
            } catch (PlaywrightException e) {
                System.err.println("[ERROR] Unable to retrieve result value: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("[ERROR] Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

}
