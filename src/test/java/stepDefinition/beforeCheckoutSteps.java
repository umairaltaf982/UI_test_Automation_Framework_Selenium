//package stepDefinition;
//
//import io.cucumber.java.Before;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.testng.annotations.Test;
//
//@Test(priority = 4)
//public class beforeCheckoutSteps extends BaseTest {
//
//    @Before
//    public void setUpScenario() {
//        setUp();
//    }
//
//    @Given("User is on checkout page")
//    public void user_is_on_checkout_page() {
//        driver.get("https://www.khazanay.pk/checkouts/cn/Z2NwLXVzLWNlbnRyYWwxOjAxSkFHRDBWN0pOU1lXTkM3VjFBQjI5RVpW?discount=");
//    }
//
//    @When("User fills the form")
//    public void user_fills_the_form() {
//        driver.findElement(By.cssSelector("#email")).sendKeys("f223737@cdf.nu.edu.pk");
//        driver.findElement(By.cssSelector("#TextField0")).sendKeys("Umair");
//        driver.findElement(By.cssSelector("#TextField1")).sendKeys("Sheikh");
//        driver.findElement(By.cssSelector("#TextField2")).sendKeys("NA");
//        driver.findElement(By.cssSelector("#TextField4")).sendKeys("Lahore");
//        driver.findElement(By.cssSelector("#TextField6")).sendKeys("03010135588");
//
//    }
//
//    @And("clicks the complete order button")
//    public void clicks_the_complete_order_button() {
//        driver.findElement(By.cssSelector("#checkout-pay-button")).click();
//    }
//
//    @Then("Checkout successfully")
//    public void checkout_page_will_appear() {
//        String currentUrl = driver.getCurrentUrl();
//        Assert.assertTrue("Checkout page did not appear", currentUrl.contains("checkouts"));
//    }
//}
