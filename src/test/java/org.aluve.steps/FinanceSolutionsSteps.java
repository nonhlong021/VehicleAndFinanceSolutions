package org.aluve.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aluve.FinanceSolutionsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class FinanceSolutionsSteps {
    FinanceSolutionsPage financeSolutionsPage;
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.wesbank.co.za/home/calculate");
        financeSolutionsPage = new FinanceSolutionsPage(driver);
    }
    @Given("the user purchases a vehicle of price {string}")
    public void theUserPurchasesAVehicleOfPrice(String price) {
        financeSolutionsPage.enterPrice(price);
        
    }

    @And("the deposit is {string}")
    public void theDepositIs(String deposit) {
        financeSolutionsPage.enterDeposit(deposit);
        
    }

    @And("the payment term is {string}")
    public void thePaymentTermIs(String term) {
        financeSolutionsPage.selectPaymentTerm(term);
    }

    @And("the balloon payment is {string}")
    public void theBalloonPaymentIs(String balloon) {
        financeSolutionsPage.addBalloonPercent(balloon);
    }

    @And("the interest rate is {string}")
    public void theInterestRateIs(String interest) {
        financeSolutionsPage.addInterestRate(interest);
    }

    @Then("the monthly repayment is {string}")
    public void theMonthlyRepaymentIs(String monthlyReturn) {
        boolean isMonthlyRetun = financeSolutionsPage.isMonthlyReturnEqualTo(monthlyReturn);
        assertTrue(isMonthlyRetun);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
