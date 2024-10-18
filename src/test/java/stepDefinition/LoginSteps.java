package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.example.utils.CSVUtils;
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

    String url = "https://www.khazanay.pk/account/login?srsltid=AfmBOooMsNU-lSbEr1ALhsmsyGQvDbvv0BRte9STfiQIzb3V8Pf31hdI";


    @Before
    public void setUpScenario() throws IOException {
        setUp();  // Initialize WebDriver and other setup
        csvData = CSVUtils.readCSV("src/test/resources/userdata.csv"); // Read CSV file
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {
        driver.get(url);
    }


    @When("user enters username and password from CSV")
    public void user_enters_username_and_password_from_csv() {
        for (String[] credentials : csvData) {
            String username = credentials[0];
            String password = credentials[1];

            WebElement email = driver.findElement(By.cssSelector("#CustomerEmail"));
            email.clear(); // Clear previous input if needed
            email.sendKeys(username);

            WebElement passwordField = driver.findElement(By.cssSelector("#CustomerPassword"));
            passwordField.clear();
            passwordField.sendKeys(password);

            click_on_login_button(); // Call the method to click the login button
            user_is_navigated_to_home_page(); // Verify navigation to home page
        }

    }

    @And("click on login button")
    public void click_on_login_button() {
        driver.findElement(By.cssSelector("#customer_login > div.t4s_field.t4s_mb_20 > button")).click();
    }

    @Then("User is navigated to home page")
    public void user_is_navigated_to_home_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("User is still on login page, login failed", url, currentUrl);
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
        driver.quit(); // Close the browser after each scenario
    }
}
