package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class beforeCheckoutSteps extends BaseTest {

    @Given("User is on checkout page")
    public void user_is_on_checkout_page() {
        driver.get("https://www.khazanay.pk/cart");  // Assuming this is the cart page URL
    }

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        driver.findElement(By.cssSelector("button.checkout")).click();  // Adjusted selector for the checkout button
    }

    @And("fills in checkout form details")
    public void fills_in_checkout_form_details() {
        driver.findElement(By.cssSelector("#email")).sendKeys("f223737@cdf.nu.edu.pk");
        driver.findElement(By.cssSelector("#TextField0")).sendKeys("Umair");
        driver.findElement(By.cssSelector("#TextField1")).sendKeys("Sheikh");
        driver.findElement(By.cssSelector("#TextField4")).sendKeys("Lahore");
        driver.findElement(By.cssSelector("#TextField6")).sendKeys("03010135588");
    }

    @Then("Checkout is completed successfully")
    public void checkout_is_completed_successfully() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Checkout process was not completed", currentUrl.contains("thank_you"));
    }
}
