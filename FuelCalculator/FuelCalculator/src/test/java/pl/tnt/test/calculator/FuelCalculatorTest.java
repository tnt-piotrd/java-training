package pl.tnt.test.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.tnt.calculator.FuelCalculatorPage;

public class FuelCalculatorTest {
    WebDriver driver;

    @Test
    public void firstTest(){
        //setting up browser for tests
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.calculator.net/fuel-cost-calculator.html");
        //clearing form
        FuelCalculatorPage fuelCalculatorPage = new FuelCalculatorPage(driver);
        fuelCalculatorPage.clearForm();
        //doing test
        String result = fuelCalculatorPage.calculateFuelAndCost("100", true,  "10", "1", true);
        Assert.assertEquals(result, "This trip will require 10 liters of fuel, which amounts to a fuel cost of $10.");
        //closing browser
        driver.quit();
    }
}
