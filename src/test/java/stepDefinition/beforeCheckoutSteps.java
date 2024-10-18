package stepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class beforeCheckoutSteps extends BaseTest {

    @Before
    public void setUpScenario() {
        setUp();
    }

    @Given("User is on the shopping cart page")
    public void user_is_on_the_shopping_cart_page() {
        driver.findElement(By.cssSelector("#t4s-mini_cart > form > div.t4s-drawer__bottom > a")).click();
    }

    @When("User enter a random message")
    public void user_enter_a_random_message() {
        driver.findElement(By.cssSelector("#CartSpecialInstructions")).sendKeys("I want the shoes in best quality");
    }

    @And("clicks the checkout button")
    public void clicks_the_checkout_button() {
        driver.findElement(By.cssSelector("#shopify-section-template--16483383607491__main > div > form > div.t4s-cartPage__footer > div > div.t4s-col-item.t4s-col-12.t4s-text-md-end.t4s-text-center.t4s-order-4.t4s-col-md-6 > div.t4s-btn-group__checkout-update > button")).click();
    }

    @Then("Checkout page will appear")
    public void checkout_page_will_appear() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Checkout page did not appear", currentUrl.contains("checkouts"));
    }
}
