package pl.tnt.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FuelCalculatorPage {
    @FindBy(name = "tripdistance")
    private WebElement tripDistanceInput;

    @FindBy(name = "fuelefficiency")
    private WebElement fuelEfficiencyInput;

    @FindBy(name = "gasprice")
    private WebElement gasPriceInput;

    @FindBy(xpath = "//input[@value='Calculate']")
    private WebElement calculateBtn;

    @FindBy(xpath = "//input[@type='button'][@value='Clear']")
    private WebElement clearBtn;

    @FindBy(className = "verybigtext")
    private WebElement tripResultText;

    @FindBy(name = "tripdistanceunit")
    private WebElement tripDistanceUnitSelect;

    @FindBy(name = "gaspriceunit")
    private WebElement gasPriceUnitSelect;


    private final WebDriver driver;

    public FuelCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String calculateFuelAndCost(String distance, boolean isDistanceInKilometers, String fuelEfficiency, String gasPrice, boolean isPricePerLiter){
        tripDistanceInput.sendKeys(distance);
        selectValue(tripDistanceUnitSelect, isDistanceInKilometers);
        fuelEfficiencyInput.sendKeys(fuelEfficiency);
        gasPriceInput.sendKeys(gasPrice);
        selectValue(gasPriceUnitSelect, isPricePerLiter);
        calculateBtn.click();
        return tripResultText.getText();
    }
    
    private void selectValue(WebElement webElement, boolean isDefaultValue){
        Select select = new Select(webElement);
        select.selectByIndex(isDefaultValue?1:0);
    }

    public void clearForm(){
        clearBtn.click();
    }
}
