package stepDefinition;

import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public class LoginSteps extends BaseTest {

    String url = "https://www.khazanay.pk/account/login";
    List<String[]> csvData; // List to store data from CSV
    boolean isLoggedIn = false; // Flag to track login status

    @Before
    public void setUpScenario() throws IOException, CsvValidationException {
        setUp();
        csvData = CSVUtils.readCSV("src/test/resources/userdata.csv"); // Read CSV file
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {
        driver.get(url);
    }

    @When("user enters username and password from CSV")
    public void user_enters_username_and_password_from_csv() {
        for (String[] credentials : csvData) {
            if (isLoggedIn) break; // Exit if already logged in

            String username = credentials[0];
            String password = credentials[1];

            WebElement email = driver.findElement(By.cssSelector("#CustomerEmail"));
            email.clear();
            email.sendKeys(username);

            WebElement passwordField = driver.findElement(By.cssSelector("#CustomerPassword"));
            passwordField.clear();
            passwordField.sendKeys(password);

            click_on_login_button(); // Click the login button

            if (is_navigated_to_home_page()) {
                isLoggedIn = true; // Set flag if login successful
            }
        }
    }

    @And("click on login button")
    public void click_on_login_button() {
        driver.findElement(By.cssSelector("#customer_login > div.t4s_field.t4s_mb_20 > button")).click();
    }

    @Then("User is navigated to home page")
    public boolean is_navigated_to_home_page() {
        String currentUrl = driver.getCurrentUrl();
        boolean success = !currentUrl.equals(url);
        Assert.assertTrue("User is still on login page, login failed", success);
        return success; // Return success status
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
        } else {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Passed Screenshot", new ByteArrayInputStream(screenshot));
        }
        if (!isLoggedIn) {
            driver.quit(); // Close the browser if not logged in
        }
    }
}
