package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;


public class LoginSteps {
    WebDriver driver = new ChromeDriver();
    String url = "https://member.daraz.pk/user/login?redirect=https%3A%2F%2Fmember.daraz.pk%2Fuser%2Fprofile";


    @Given("User is on login page")
    public void user_is_on_login_page() {
        driver.get(url);
    }

    @When("User enters username and password")
    public void user_enters_username_and_password() {
        WebElement email = driver.findElement(By.cssSelector("input[type='text']"));
        email.sendKeys("f223737@cfd.nu.edu.pk");
        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys("abc@12345");
    }

    @And("click on login button")
    public void click_on_login_button() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("User is navigated to home page")
    public void user_is_navigated_to_home_page() {
        if (!driver.getCurrentUrl().equals(url)) {
            user_enters_username_and_password();
        } else {
            return;
        }
    }

    @After
    public void TearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
        } else {
            // Optionally, take a screenshot or just log the result.
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Passed Screenshot", new ByteArrayInputStream(screenshot));
        }

        driver.quit();
    }


}
