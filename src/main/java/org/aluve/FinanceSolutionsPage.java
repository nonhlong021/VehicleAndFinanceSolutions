package org.aluve;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FinanceSolutionsPage {
    WebDriver driver;

    public FinanceSolutionsPage(WebDriver driver) {
        this.driver = driver;
    }

    By byVehiclePurchasePrice = By.xpath("//input[@class='input-field-input']");
    By byDeposit = By.xpath("//wol-ranger[@formcontrolname='deposit']//label//following::div[1]");
    By byPaymentTerm = By.xpath("//select[@class='wb-native-select-element']");
    By byBallonPercentage = By.xpath("//wol-ranger[@type='percent']//div[@class='wol-slider-range']//preceding-sibling::div//div[1]");

    By byInterestRate = By.xpath("(//div[@class='wol-slider-manual'])[3]");

    By byMonthlyReturns = By.xpath("//span[@class='output value']");

    public void enterPrice(String price) {
        driver.findElement(byVehiclePurchasePrice).clear();
        driver.findElement(byVehiclePurchasePrice).sendKeys(price);
    }

    public void enterDeposit(String deposit){
        driver.findElement(byDeposit).click();
        driver.findElement(byDeposit).sendKeys(deposit);
        driver.findElement(byDeposit).click();

    }

    public void selectPaymentTerm(String term){
        WebElement selectElement = driver.findElement(byPaymentTerm);
        Select select = new Select(selectElement);
        select.selectByVisibleText(term);
    }
    public void addBalloonPercent(String balloon){
        driver.findElement(byBallonPercentage).click();
        driver.findElement(byBallonPercentage).sendKeys(balloon);
        driver.findElement(byBallonPercentage).click();
    }

    public void addInterestRate(String interest){
        driver.findElement(byInterestRate).click();
        driver.findElement(byInterestRate).sendKeys(interest);
        driver.findElement(byInterestRate).click();
    }

    public boolean isMonthlyReturnEqualTo(String value){
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(45L));
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(byMonthlyReturns, value));
        } catch (Exception e) {
            return false;
        }
    }
}
