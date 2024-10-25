package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchSteps extends BaseTest {

    String url = "https://www.khazanay.pk/";

    @Given("User is on Dashboard page after login")
    public void user_is_on_dashboard_page_after_login() {
        driver.get(url);  // Navigate to the dashboard/home page after login
    }

    @When("User enters search term")
    public void user_enters_search_term() {
        WebElement search = driver.findElement(By.cssSelector("input[name='q']"));  // Adjusted selector to fit your website
        search.sendKeys("sneakers for men");
    }

    @And("clicks on search button")
    public void clicks_on_search_button() {
        WebElement searchBtn = driver.findElement(By.cssSelector("button[type='submit']"));  // Adjusted selector
        searchBtn.click();
    }

    @Then("User is navigated to the search results page")
    public void user_is_navigated_to_the_search_results_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("User is not on the search results page", currentUrl.contains("search"));
    }
}
