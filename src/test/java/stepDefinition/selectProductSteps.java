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
        driver.findElement(By.cssSelector("#snize-product-8059545157827 > a > div > div > span.snize-thumbnail > img")).click();
    }

    @And("clicks the add to cart button")
    public void clicks_the_add_to_cart_button() {
        driver.findElement(By.cssSelector("#product-form-8059545157827template--16483384295619__main > div.t4s-product-form__buttons > div.t4s-d-flex.t4s-flex-wrap > button")).click();
    }

    @Then("Product is added to the cart")
    public void product_is_added_to_the_cart() {
        driver.get("https://www.khazanay.pk/checkouts/cn/Z2NwLXVzLWNlbnRyYWwxOjAxSkFHRDBWN0pOU1lXTkM3VjFBQjI5RVpW?discount=");
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
