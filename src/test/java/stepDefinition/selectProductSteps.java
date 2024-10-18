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

import java.io.ByteArrayInputStream;

public class selectProductSteps extends BaseTest {
    @Before
    public void setUpScenario() {
        setUp();
    }

    @Given("User is on the product details page")
    public void user_is_on_the_product_details_page() {
    }

    @When("User selects the product")
    public void user_selects_the_product() {
        driver.findElement(By.className("Ms6aG")).click();
    }

    @And("clicks the add to cart button")
    public void clicks_the_add_to_cart_button() {
        driver.findElement(By.className("pdp-button_theme_orange")).click();
    }

    @Then("Product is added to the cart")
    public void product_is_added_to_the_cart() {
        String successMessage = driver.findElement(By.className("cart-message-text")).getText();
        if (successMessage == "Added to cart successfully!") {
            driver.quit();
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
