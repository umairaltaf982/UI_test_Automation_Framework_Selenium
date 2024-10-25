package org.codcop.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "eid")
    private WebElement usernameField;

    @FindBy(id = "pw")
    private WebElement passwordField;

    @FindBy(id = "submit")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        usernameField.clear();
        passwordField.clear();
        loginButton.submit();

    }
}