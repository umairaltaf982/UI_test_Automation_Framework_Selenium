package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {
    @Given("User is on login page")
    public void user_is_on_login_page() {
        System.out.println("Inside Step - user is on login page");
    }

    @When("User enters username and password")
    public void user_enters_username_and_password() {
        System.out.println("Inside Step - user enter username and password");
    }

    @And("click on login button")
    public void click_on_login_button() {
        System.out.println("Inside Step - clicks the login button");
    }

    @Then("User is navigated to home page")
    public void user_is_navigated_to_home_page() {
        System.out.println("Inside Step - navigates to the home page");
    }

}
