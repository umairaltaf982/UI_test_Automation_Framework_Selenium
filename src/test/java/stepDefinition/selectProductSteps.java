package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class selectProductSteps extends BaseTest {

    @Given("User is on the search results page")
    public void user_is_on_the_search_results_page() {
        // The URL should be the results page for a product search
        Assert.assertTrue("Not on the search results page", driver.getCurrentUrl().contains("search"));
    }

    @When("User selects the first product from the search results")
    public void user_selects_the_first_product_from_the_search_results() {
        driver.findElement(By.cssSelector(".product-grid-item a")).click();  // Adjusted selector for the first product
    }

    @And("clicks on Add to Cart button")
    public void clicks_on_add_to_cart_button() {
        driver.findElement(By.cssSelector("button.add-to-cart")).click();  // Adjusted selector for the add-to-cart button
    }

    @Then("Product is successfully added to the cart")
    public void product_is_successfully_added_to_the_cart() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Product is not added to the cart", currentUrl.contains("cart"));
    }
}
