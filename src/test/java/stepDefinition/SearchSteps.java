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

public class SearchSteps extends BaseTest {

    String url = "https://member.daraz.pk/user/profile#/";

    @Before
    public void setUpScenario() {
        setUp();
    }

    @Given("User is on Dashboard page")
    public void user_is_on_dashboard_page() {
        driver.get(url);
    }

    @When("User enters search creditentials")
    public void user_enters_search_creditentials() {
        WebElement search = driver.findElement(By.cssSelector("input[type='search']"));
        search.sendKeys("winter gloves");
    }

    @And("click on search button")
    public void click_on_search_button() {
        WebElement searchBtn = driver.findElement(By.className("search-box__button--1oH7"));
        searchBtn.click();
    }

    @Then("User is navigated to product related detail page")
    public void user_is_navigated_to_product_related_detail_page() {
        
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
