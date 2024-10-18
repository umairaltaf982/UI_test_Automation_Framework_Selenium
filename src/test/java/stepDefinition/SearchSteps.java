package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchSteps extends LoginSteps {
    WebDriver driver = new ChromeDriver();
    String url = "https://member.daraz.pk/user/profile#/";

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
        if (!driver.getCurrentUrl().equals(url)) {
            user_enters_search_creditentials();
        } else {
            return;
        }
    }
}
