package org.codcop.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.codcop.automation.pages.LoginPage;
import org.codcop.automation.utils.CSVUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.List;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private String Url = "http://slate.nu.edu.pk/portal/relogin";

    @Given("User is on login page")
    public void user_is_on_login_page() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get(Url);
        loginPage = new LoginPage(driver);
    }

    @When("User enters username and password from CSV")
    public void user_enters_username_and_password() throws IOException {
        List<String[]> csvData = CSVUtils.readCSV("src/test/resources/userdata.csv");
        for (String[] credentials : csvData) {

            String username = credentials[0];
            String password = credentials[1];
            loginPage.login(username, password);
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue("User is logged in with invalid credentials", currentUrl.equals(Url));
        }
    }

    @Then("User should be logged in")
    public void user_should_be_logged_in() {
        driver.quit();
    }
}