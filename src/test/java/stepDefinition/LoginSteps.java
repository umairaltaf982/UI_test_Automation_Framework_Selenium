package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.ByteArrayInputStream;

public class LoginSteps extends BaseTest {

    String url = "https://www.khazanay.pk/account/login?srsltid=AfmBOooMsNU-lSbEr1ALhsmsyGQvDbvv0BRte9STfiQIzb3V8Pf31hdI";

    @Before
    public void setUpScenario() {
        setUp();
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {
        driver.get(url);
    }

    @When("User enters username and password")
    public void user_enters_username_and_password() {
        WebElement email = driver.findElement(By.cssSelector("#CustomerEmail"));
        email.sendKeys("f223737@cfd.nu.edu.pk");
        WebElement password = driver.findElement(By.cssSelector("#CustomerPassword"));
        password.sendKeys("abc@12345");
    }

    @And("click on login button")
    public void click_on_login_button() {
        driver.findElement(By.cssSelector("#customer_login > div.t4s_field.t4s_mb_20 > button")).click();
    }

    @Then("User is navigated to home page")
    public void user_is_navigated_to_home_page() {
        if (!driver.getCurrentUrl().equals(url)) {
            user_enters_username_and_password();
        }
    }

    @After
    public void TearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
        } else {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Passed Screenshot", new ByteArrayInputStream(screenshot));
        }
    }
}
